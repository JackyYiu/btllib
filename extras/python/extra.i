%rename(__str__) btllib::Graph::to_string;
%rename(__bool__) btllib::SeqReader::Record::operator bool();
%rename(__bool__) btllib::Indexlr::Record::operator bool();

%rename (SeqReaderRecord) btllib::SeqReader::Record;
%rename (SeqReaderFlag) btllib::SeqReader::Flag;
%rename (IndexlrRecord) btllib::Indexlr::Record;
%rename (IndexlrFlag) btllib::Indexlr::Flag;

%{
  using btllib::SpacedSeed;
%}

%ignore btllib::CString;
%ignore btllib::CString::operator=;
%ignore btllib::OrderQueue;
%ignore btllib::OrderQueue::Block;
%ignore btllib::OrderQueue::Slot;
%ignore btllib::OrderQueue::Block::operator=;
%ignore btllib::OrderQueue::Block::operator=;
%ignore btllib::OrderQueue::Slot::operator=;
%ignore btllib::OrderQueue::Slot::operator=;

%feature("flatnested", "1");

%ignore btllib::DataStream::operator FILE*() const;
%ignore btllib::DataSource::operator FILE*() const;
%ignore btllib::DataSink::operator FILE*() const;

%ignore btllib::BLOOM_FILTER_MAGIC_HEADER;
%ignore btllib::COUNTING_BLOOM_FILTER_MAGIC_HEADER;

%ignore btllib::SeqReader::read_fasta_buffer;
%ignore btllib::SeqReader::read_fastq_buffer;
%ignore btllib::SeqReader::read_sam_buffer;
%ignore btllib::SeqReader::read_gfa2_buffer;

%ignore btllib::SeqReader::read_fasta_transition;
%ignore btllib::SeqReader::read_fastq_transition;
%ignore btllib::SeqReader::read_sam_transition;
%ignore btllib::SeqReader::read_gfa2_transition;

%ignore btllib::SeqReader::read_fasta_file;
%ignore btllib::SeqReader::read_fastq_file;
%ignore btllib::SeqReader::read_sam_file;
%ignore btllib::SeqReader::read_gfa2_file;

%ignore btllib::NtHash::NtHash(const char*, size_t, unsigned, unsigned, size_t pos = 0);