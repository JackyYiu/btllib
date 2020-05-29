#ifndef BTLLIB_DATA_STREAM_HPP
#define BTLLIB_DATA_STREAM_HPP

#include "status.hpp"
#include "util.hpp"

#include <algorithm>
#include <cassert>
#include <cerrno>
#include <csignal>
#include <cstdarg>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <map>
#include <mutex>
#include <string>
#include <vector>

#include <dlfcn.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

namespace btllib {

static const int PIPE_READ_END = 0;
static const int PIPE_WRITE_END = 1;
static const int COMM_BUFFER_SIZE = 1024;
static const mode_t PIPE_PERMISSIONS = 0666;

using PipeId = unsigned long;
class _Pipeline;

// clang-format off
inline bool& process_spawner_initialized() { static bool _process_spawner_initialized; return _process_spawner_initialized; }
inline int* process_spawner_parent2child_fd() { static int _process_spawner_parent2child_fd[2]; return _process_spawner_parent2child_fd; }
inline int* process_spawner_child2parent_fd() { static int _process_spawner_child2parent_fd[2]; return _process_spawner_child2parent_fd; }
inline std::mutex& process_spawner_comm_mutex() { static std::mutex _process_spawner_comm_mutex; return _process_spawner_comm_mutex; };
inline PipeId new_pipe_id() { static PipeId _last_pipe_id = 0; return _last_pipe_id++; }
inline std::map<std::string, _Pipeline>& pipeline_map() { static std::map<std::string, _Pipeline> _pipeline_map; return _pipeline_map; }
// clang-format on

static inline std::string
get_pipepath(const PipeId id)
{
  return "btllib-" + std::to_string(getpid()) + "-" + std::to_string(id);
}

class DataStream
{
public:
  enum Operation
  {
    READ,
    WRITE,
    APPEND,
    CLOSE
  };

  DataStream(const std::string& path, Operation op);
  ~DataStream() { close(); }
  void close();

  FILE* operator*() const { return file; }
  FILE* operator->() const { return file; }
  operator FILE*() const { return file; }

protected:
  std::string streampath;
  Operation op;
  std::string pipepath;
  FILE* file = nullptr;
  bool closed = false;
};

class DataSource : public DataStream
{

public:
  DataSource(const std::string& path)
    : DataStream(path, READ)
  {}
};

class DataSink : public DataStream
{

public:
  DataSink(const std::string& path, bool append = false)
    : DataStream(path, append ? APPEND : WRITE)
  {}
};

inline DataStream::DataStream(const std::string& path, Operation op)
  : streampath(path)
  , op(op)
{
  std::unique_lock<std::mutex> lock(process_spawner_comm_mutex());

  write(process_spawner_parent2child_fd()[PIPE_WRITE_END], &op, sizeof(op));

  size_t pathlen = path.size() + 1;
  check_error(pathlen > COMM_BUFFER_SIZE,
              "Stream path length too large for the buffer.");
  write(process_spawner_parent2child_fd()[PIPE_WRITE_END],
        &pathlen,
        sizeof(pathlen));
  write(
    process_spawner_parent2child_fd()[PIPE_WRITE_END], path.c_str(), pathlen);

  char buf[COMM_BUFFER_SIZE];
  read(process_spawner_child2parent_fd()[PIPE_READ_END],
       &pathlen,
       sizeof(pathlen));
  read(process_spawner_child2parent_fd()[PIPE_READ_END], buf, pathlen);
  pipepath = buf;

  file = fopen(pipepath.c_str(), op == READ ? "r" : "w");
  unlink(pipepath.c_str());
}

inline void
DataStream::close()
{
  if (!closed) {
    std::unique_lock<std::mutex> lock(process_spawner_comm_mutex());

    if (op == READ) {
      op = CLOSE;
      if (file != stdin) {
        write(
          process_spawner_parent2child_fd()[PIPE_WRITE_END], &op, sizeof(op));

        size_t pathlen = pipepath.size() + 1;
        check_error(pathlen > COMM_BUFFER_SIZE,
                    "Stream path length too large for the buffer.");
        write(process_spawner_parent2child_fd()[PIPE_WRITE_END],
              &pathlen,
              sizeof(pathlen));
        write(process_spawner_parent2child_fd()[PIPE_WRITE_END],
              pipepath.c_str(),
              pathlen);

        read(process_spawner_child2parent_fd()[PIPE_READ_END], &op, 1);

        std::fclose(file);
      }
    } else if (op == WRITE || op == APPEND) {
      op = CLOSE;
      if (file != stdout) {
        std::fclose(file);

        write(
          process_spawner_parent2child_fd()[PIPE_WRITE_END], &op, sizeof(op));

        size_t pathlen = pipepath.size() + 1;
        check_error(pathlen > COMM_BUFFER_SIZE,
                    "Stream path length too large for the buffer.");
        write(process_spawner_parent2child_fd()[PIPE_WRITE_END],
              &pathlen,
              sizeof(pathlen));
        write(process_spawner_parent2child_fd()[PIPE_WRITE_END],
              pipepath.c_str(),
              pathlen);

        read(process_spawner_child2parent_fd()[PIPE_READ_END], &op, 1);
      }
    }

    closed = true;
  }
}

class _Pipeline
{

public:
  enum Direction
  {
    SOURCE,
    SINK
  };

  _Pipeline() {}

  _Pipeline(std::string pipepath,
            Direction direction,
            pid_t pid_first,
            pid_t pid_last)
    : pipepath(std::move(pipepath))
    , direction(direction)
    , pid_first(pid_first)
    , pid_last(pid_last)
  {}

  void finish();

  std::string pipepath;
  Direction direction = SOURCE;
  pid_t pid_first = -1;
  pid_t pid_last = -1;
  bool closed = false;
};

inline void
_Pipeline::finish()
{
  if (!closed) {
    if (direction == SOURCE) {
      kill(pid_first, SIGTERM);
      int status;
      waitpid(pid_first, &status, 0);
      waitpid(pid_last, &status, 0);
    } else if (direction == SINK) {
      int status;
      waitpid(pid_last, &status, 0);
    }

    pid_t pid;
    int status;
    while ((pid = waitpid(-1, &status, WNOHANG)) > 0) {
      if (status != 0) {
        std::cerr << "Helper process failed before data stream was closed:"
                  << std::endl;
        if (WIFEXITED(status)) { // NOLINT
          std::cerr << "PID " << pid << " exited with status "
                    << WEXITSTATUS(status) << std::endl; // NOLINT
        } else if (WIFSIGNALED(status)) {                // NOLINT
          std::cerr << "PID " << pid << " killed by signal "
                    << WTERMSIG(status) // NOLINT
                    << std::endl;
        } else {
          std::cerr << "PID " << pid << " exited with code " << status
                    << std::endl;
        }
        std::exit(EXIT_FAILURE);
      }
    }

    closed = true;
  }
}

static inline bool
process_spawner_init();

static const bool process_spawner_initializer = process_spawner_init();

static inline std::string
get_pipeline_cmd(const std::string& path, DataStream::Operation op);

static inline _Pipeline
run_pipeline_cmd(const std::string& cmd, DataStream::Operation op);

inline void
sigchld_handler(const int sig) {}

static inline bool
process_spawner_init()
{
  if (!process_spawner_initialized()) {
    process_spawner_initialized() = true;

    process_spawner_parent2child_fd()[PIPE_READ_END] = -1;
    process_spawner_parent2child_fd()[PIPE_WRITE_END] = -1;
    process_spawner_child2parent_fd()[PIPE_READ_END] = -1;
    process_spawner_child2parent_fd()[PIPE_WRITE_END] = -1;
    check_error(pipe(process_spawner_parent2child_fd()) == -1,
                "Error opening a pipe.");
    check_error(pipe(process_spawner_child2parent_fd()) == -1,
                "Error opening a pipe.");

    pid_t pid = fork();
    if (pid == 0) {
      close(process_spawner_parent2child_fd()[PIPE_WRITE_END]);
      close(process_spawner_child2parent_fd()[PIPE_READ_END]);

      struct sigaction action; // NOLINT
      action.sa_handler = sigchld_handler;
      sigemptyset(&action.sa_mask);
      action.sa_flags = SA_RESTART;
      sigaction(SIGCHLD, &action, nullptr);

      DataStream::Operation op;
      char buf[COMM_BUFFER_SIZE];
      size_t pathlen;
      _Pipeline pipeline;
      for (;;) {
        if (read(process_spawner_parent2child_fd()[PIPE_READ_END],
                 &op,
                 sizeof(op)) <= 0) {
          kill(0, SIGTERM);
          std::exit(EXIT_SUCCESS);
        }

        read(process_spawner_parent2child_fd()[PIPE_READ_END],
             &pathlen,
             sizeof(pathlen));
        read(process_spawner_parent2child_fd()[PIPE_READ_END], buf, pathlen);

        switch (op) {
          case DataStream::Operation::READ:
          case DataStream::Operation::WRITE:
          case DataStream::Operation::APPEND:
            pipeline = run_pipeline_cmd(get_pipeline_cmd(buf, op), op);

            pathlen = pipeline.pipepath.size() + 1;
            check_error(pathlen > COMM_BUFFER_SIZE,
                        "Stream path length too large for the buffer.");
            write(process_spawner_child2parent_fd()[PIPE_WRITE_END],
                  &pathlen,
                  sizeof(pathlen));
            write(process_spawner_child2parent_fd()[PIPE_WRITE_END],
                  pipeline.pipepath.c_str(),
                  pathlen);

            pipeline_map()[pipeline.pipepath] = pipeline;
            break;
          case DataStream::Operation::CLOSE:
            pipeline = pipeline_map()[std::string(buf)];
            pipeline.finish();
            pipeline_map().erase(std::string(buf));
            write(process_spawner_child2parent_fd()[PIPE_WRITE_END], &op, 1);
            break;
          default:
            log_error("Invalid stream operation.");
            std::exit(EXIT_FAILURE);
        }
      }
    }
    close(process_spawner_parent2child_fd()[PIPE_READ_END]);
    close(process_spawner_child2parent_fd()[PIPE_WRITE_END]);
  }
  return true;
}

static inline std::string
get_pipeline_cmd(const std::string& path, DataStream::Operation op)
{
  struct Datatype
  {
    std::vector<std::string> prefixes;
    std::vector<std::string> suffixes;
    std::vector<std::string> cmds_check_existence;
    std::vector<std::string> read_cmds;
    std::vector<std::string> write_cmds;
    std::vector<std::string> append_cmds;
  };

  // clang-format off
  static const Datatype DATATYPES[] {
    { { "http://", "https://", "ftp://" }, {}, { "command -v wget" }, { "wget -O-" }, { "" }, { "" } },
    { {}, { ".url" }, { "command -v wget" }, { "wget -O- -i" }, { "" }, { "" } },
    { {}, { ".ar" }, { "command -v ar" }, { "ar -p" }, { "" }, { "" } },
    { {}, { ".tar" }, { "command -v tar" }, { "tar -xOf" }, { "" }, { "" } },
    { {}, { ".tgz" }, { "command -v tar" }, { "tar -zxOf" }, { "" }, { "" } },
    { {}, { ".gz", ".z" }, { "command -v pigz", "command -v gzip" }, { "pigz -dc", "gzip -dc" }, { "pigz >", "gzip >" }, { "pigz >>", "gzip >>" } },
    { {}, { ".bz2" }, { "command -v bzip2" }, { "bunzip2 -dc" }, { "bzip2 >" }, { "bzip2 >>" } },
    { {}, { ".xz" }, { "command -v xz" }, { "unxz -dc" }, { "xz -T0 >" }, { "xz -T0 >>" } },
    { {}, { ".7z" }, { "command -v 7z" }, { "7z -so e" }, { "7z -si a" }, { "7z -si a" } },
    { {}, { ".zip" }, { "command -v zip" }, { "unzip -p" }, { "" }, { "" } },
    { {}, { ".bam", ".cram" }, { "command -v samtools" }, { "samtools view -h" }, { "samtools -Sb - >" }, { "samtools -Sb - >>" } },
  };
  // clang-format on
  std::string default_cmd = "cat";
  if (op == DataStream::Operation::WRITE) {
    default_cmd += " >";
  } else if (op == DataStream::Operation::APPEND) {
    default_cmd += " >>";
  }

  std::string path_trimmed = path;
  std::vector<std::string> cmd_layers;
  for (;;) {
    bool found_datatype = false;
    for (const auto& datatype : DATATYPES) {
      size_t trim_start = 0, trim_end = 0;
      bool this_datatype = false;
      for (const auto& prefix : datatype.prefixes) {
        if (starts_with(path_trimmed, prefix)) {
          this_datatype = true;
          trim_start += prefix.size();
          break;
        }
      }
      for (const auto& suffix : datatype.suffixes) {
        if (ends_with(path_trimmed, suffix)) {
          this_datatype = true;
          trim_end += suffix.size();
          break;
        }
      }

      if (this_datatype) {
        found_datatype = true;
        bool found_cmd = false;
        int cmd_idx = 0;
        for (const auto& existence_cmd : datatype.cmds_check_existence) {
          pid_t pid = fork();
          if (pid == 0) {
            int null_fd = open("/dev/null", O_WRONLY, 0);
            dup2(null_fd, STDOUT_FILENO);
            dup2(null_fd, STDERR_FILENO);
            close(null_fd);

            execlp("sh", "sh", "-c", existence_cmd.c_str());
            log_error("exec failed: sh -c \"" + existence_cmd + "\'");
            std::exit(EXIT_FAILURE);
          } else {
            check_error(pid == -1, "Error on fork.");
            int status;
            check_error(waitpid(pid, &status, 0) != pid, "waitpid error.");
            if (!WIFSIGNALED(status) &&
                (!WIFEXITED(status) || WEXITSTATUS(status) == 0)) { // NOLINT
              found_cmd = true;
              break;
            }
          }
          cmd_idx++;
        }

        if (found_cmd) {
          std::string cmd;
          switch (op) {
            case DataStream::Operation::READ:
              cmd = datatype.read_cmds[cmd_idx];
              break;
            case DataStream::Operation::WRITE:
              cmd = datatype.write_cmds[cmd_idx];
              break;
            case DataStream::Operation::APPEND:
              cmd = datatype.append_cmds[cmd_idx];
              break;
            default:
              log_error("Invalid operation");
              std::exit(EXIT_FAILURE);
          }
          if (cmd.empty()) {
            log_warning("Filetype recognized for '" + path_trimmed +
                        "', but no tool available to work with it.");
          } else {
            cmd_layers.push_back(cmd);
          }
        } else {
          log_warning("Filetype recognized for '" + path_trimmed +
                      "', but no tool available to work with it.");
        }
        path_trimmed.erase(0, trim_start);
        path_trimmed.erase(path_trimmed.size() - trim_end);
      }
    }
    if (!found_datatype) {
      break;
    }
  }
  if (cmd_layers.empty()) {
    cmd_layers.push_back(default_cmd);
  }
  if (op == DataStream::Operation::WRITE ||
      op == DataStream::Operation::APPEND) {
    std::reverse(cmd_layers.begin(), cmd_layers.end());
  }

  std::string result_cmd;
  for (size_t i = 0; i < cmd_layers.size(); i++) {
    auto& cmd = cmd_layers[i];
    if (op == DataStream::Operation::WRITE ||
        op == DataStream::Operation::APPEND) {
      if (i == cmd_layers.size() - 1) {
        if (cmd.back() == '>') {
          cmd += path;
        } else {
          cmd += " ";
          cmd += path;
        }
      } else {
        if (cmd.back() == '>') {
          while (cmd.back() == '>' || cmd.back() == ' ') {
            cmd.pop_back();
          }
        } else {
          cmd += " -";
        }
      }
    } else {
      if (i == 0) {
        cmd += " ";
        cmd += path;
      } else {
        cmd += " -";
      }
    }
    if (i > 0) {
      result_cmd += " | ";
    }
    result_cmd += cmd;
  }

  check_error(result_cmd.empty(),
              (op == DataStream::Operation::READ ? "Error loading from "
                                                 : "Error saving to ") +
                path);
  return result_cmd;
}

static inline _Pipeline
run_pipeline_cmd(const std::string& cmd, DataStream::Operation op)
{
  std::string pipepath = get_pipepath(new_pipe_id());
  unlink(pipepath.c_str());
  mkfifo(pipepath.c_str(), PIPE_PERMISSIONS);

  auto individual_cmds = split(cmd, " | ");
  check_error(individual_cmds.empty(),
              "Error processing data stream commands.");
  std::reverse(individual_cmds.begin(), individual_cmds.end());

  std::vector<pid_t> pids;

  int input_fd[2], output_fd[2];
  input_fd[PIPE_READ_END] = -1;
  input_fd[PIPE_WRITE_END] = -1;
  output_fd[PIPE_READ_END] = -1;
  output_fd[PIPE_WRITE_END] = -1;

  size_t i = 0;
  for (const auto& individual_cmd : individual_cmds) {
    auto args = split(individual_cmd, " ");
    std::for_each(args.begin(), args.end(), trim);

    std::string stdout_to_file;
    decltype(args)::iterator it;
    for (it = args.begin(); it != args.end(); ++it) {
      if (it->front() == '>') {
        stdout_to_file = it->substr(1);
        break;
      }
    }
    if (it != args.end()) {
      args.erase(it);
    }

    char* const* argv = new char*[args.size() + 2];
    ((char*&)(argv[0])) = (char*)(args[0].c_str());
    for (size_t i = 0; i < args.size(); i++) {
      ((char*&)(argv[i + 1])) = (char*)(args[i].c_str());
    }
    ((char*&)(argv[args.size() + 1])) = nullptr;

    if (i < individual_cmds.size() - 1) {
      check_error(pipe(input_fd) == -1, "Error opening a pipe.");
      fcntl(input_fd[PIPE_READ_END], F_SETFD, FD_CLOEXEC);
      fcntl(input_fd[PIPE_WRITE_END], F_SETFD, FD_CLOEXEC);
    }

    pid_t pid = fork();
    if (pid == 0) {
      if (op == DataStream::Operation::READ) {
        if (i == 0) {
          int fd = open(pipepath.c_str(), O_WRONLY);
          dup2(fd, STDOUT_FILENO);
          close(fd);
        } else {
          dup2(output_fd[PIPE_WRITE_END], STDOUT_FILENO);
          close(output_fd[PIPE_READ_END]);
          close(output_fd[PIPE_WRITE_END]);
        }

        if (i < individual_cmds.size() - 1) {
          dup2(input_fd[PIPE_READ_END], STDIN_FILENO);
          close(input_fd[PIPE_READ_END]);
          close(input_fd[PIPE_WRITE_END]);
        }

        execvp(argv[0], argv + 1);
        std::string argv_print;
        for (int i = 0; argv[i] != nullptr; i++) {
          argv_print += " " + std::string(argv[i]);
        }
        log_error("exec failed: " + argv_print);
        std::exit(EXIT_FAILURE);
      } else {
        if (i == individual_cmds.size() - 1) {
          int fd = open(pipepath.c_str(), O_RDONLY);
          dup2(fd, STDIN_FILENO);
          close(fd);
        } else {
          dup2(input_fd[PIPE_READ_END], STDIN_FILENO);
          close(input_fd[PIPE_READ_END]);
          close(input_fd[PIPE_WRITE_END]);
        }

        if (!stdout_to_file.empty()) {
          int outfd =
            open(stdout_to_file.c_str(),
                 O_WRONLY | O_CREAT |
                   (op == DataStream::Operation::APPEND ? O_APPEND : 0),
                 S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH);
          dup2(outfd, STDOUT_FILENO);
          close(outfd);
        } else if (i > 0) {
          dup2(output_fd[PIPE_WRITE_END], STDOUT_FILENO);
          close(output_fd[PIPE_READ_END]);
          close(output_fd[PIPE_WRITE_END]);
        }

        execvp(argv[0], argv + 1);
        std::string argv_print;
        for (int i = 0; argv[i] != nullptr; i++) {
          argv_print += " " + std::string(argv[i]);
        }
        log_error("exec failed: " + argv_print);
        exit(EXIT_FAILURE);
      }
    }
    check_error(pid == -1, "Error on fork.");

    delete[] argv;

    pids.push_back(pid);

    if (i > 0) {
      close(output_fd[PIPE_READ_END]);
      close(output_fd[PIPE_WRITE_END]);
    }

    if (i < individual_cmds.size() - 1) {
      output_fd[PIPE_READ_END] = input_fd[PIPE_READ_END];
      output_fd[PIPE_WRITE_END] = input_fd[PIPE_WRITE_END];
    }

    i++;
  }

  return _Pipeline(pipepath,
                   op == DataStream::Operation::READ
                     ? _Pipeline::Direction::SOURCE
                     : _Pipeline::Direction::SINK,
                   pids.back(),
                   pids.front());
}

} // namespace btllib

#endif
