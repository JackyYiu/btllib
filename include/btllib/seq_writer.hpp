#ifndef BTLLIB_SEQ_WRITER_HPP
#define BTLLIB_SEQ_WRITER_HPP

#include "data_saveload.hpp"

#include <cstdio>
#include <string>

namespace btllib {

class SeqWriter
{

public:
  enum Format
  {
    FASTA,
    FASTQ
  };

  SeqWriter(const char* sink, Format format, bool append = false);
  ~SeqWriter();

  void close();

  void write(const std::string& name,
             const std::string& comment,
             const std::string& seq,
             const std::string& qual);

private:
  const char* sink;
  std::FILE* output;
  bool closed;
  Format format;
  char headerchar;
};

inline SeqWriter::SeqWriter(const char* sink, Format format, bool append)
  : sink(sink)
  , output(data_save(sink, append))
  , closed(false)
  , format(format)
  , headerchar(format == FASTA ? '>' : '@')
{}

inline SeqWriter::~SeqWriter()
{
  close();
}

inline void
SeqWriter::close()
{
  if (!closed) {
    fclose(output);
  }
  closed = true;
}

inline void
SeqWriter::write(const std::string& name,
                 const std::string& comment,
                 const std::string& seq,
                 const std::string& qual)
{
  fwrite(&headerchar, 1, 1, output);
  if (!name.empty()) {
    fwrite(name.c_str(), 1, name.size(), output);
  }
  if (!comment.empty()) {
    fwrite(" ", 1, 1, output);
    fwrite(comment.c_str(), 1, comment.size(), output);
    fwrite("\n", 1, 1, output);
  }
  check_error(seq.empty(), "Attempted to write empty sequence.");
  fwrite(seq.c_str(), 1, seq.size(), output);
  fwrite("\n", 1, 1, output);
  if (format == FASTQ) {
    check_error(seq.size() != qual.size(),
                "Quality must be the same length as sequence.");
    fwrite("+\n", 1, 2, output);
    fwrite(qual.c_str(), 1, qual.size(), output);
    fwrite("\n", 1, 1, output);
  }
}

} // namespace btllib

#endif