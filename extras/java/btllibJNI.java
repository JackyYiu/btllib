/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.2
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package btllib;

public class btllibJNI {
  public final static native long new_SeqWriter__SWIG_0(String jarg1, int jarg2, boolean jarg3);
  public final static native long new_SeqWriter__SWIG_1(String jarg1, int jarg2);
  public final static native long new_SeqWriter__SWIG_2(String jarg1);
  public final static native void SeqWriter_close(long jarg1, SeqWriter jarg1_);
  public final static native void SeqWriter_write(long jarg1, SeqWriter jarg1_, String jarg2, String jarg3, String jarg4, String jarg5);
  public final static native void delete_SeqWriter(long jarg1);
  public final static native String KMER_COUNTING_BLOOM_FILTER_MAGIC_HEADER_get();
  public final static native int PIPE_READ_END_get();
  public final static native int PIPE_WRITE_END_get();
  public final static native int COMM_BUFFER_SIZE_get();
  public final static native long PIPE_PERMISSIONS_get();
  public final static native long process_spawner_initialized();
  public final static native long process_spawner_parent2child_fd();
  public final static native long process_spawner_child2parent_fd();
  public final static native long process_spawner_comm_mutex();
  public final static native long new_pipe_id();
  public final static native long pipeline_map();
  public final static native String get_pipepath(long jarg1);
  public final static native void read_from_child(long jarg1, long jarg2);
  public final static native void write_to_child(long jarg1, long jarg2);
  public final static native void check_children_failures();
  public final static native void end_child();
  public final static native void read_from_parent(long jarg1, long jarg2);
  public final static native void write_to_parent(long jarg1, long jarg2);
  public final static native long new_DataStream(String jarg1, int jarg2);
  public final static native void delete_DataStream(long jarg1);
  public final static native void DataStream_close(long jarg1, DataStream jarg1_);
  public final static native long DataStream___ref__(long jarg1, DataStream jarg1_);
  public final static native long DataStream___deref__(long jarg1, DataStream jarg1_);
  public final static native long new_DataSource(String jarg1);
  public final static native void delete_DataSource(long jarg1);
  public final static native long new_DataSink__SWIG_0(String jarg1, boolean jarg2);
  public final static native long new_DataSink__SWIG_1(String jarg1);
  public final static native void delete_DataSink(long jarg1);
  public final static native long new_DataStreamPipeline__SWIG_0();
  public final static native long new_DataStreamPipeline__SWIG_1(int jarg1, long jarg2, long jarg3);
  public final static native void DataStreamPipeline_finish(long jarg1, DataStreamPipeline jarg1_);
  public final static native void DataStreamPipeline_direction_set(long jarg1, DataStreamPipeline jarg1_, int jarg2);
  public final static native int DataStreamPipeline_direction_get(long jarg1, DataStreamPipeline jarg1_);
  public final static native void DataStreamPipeline_pid_first_set(long jarg1, DataStreamPipeline jarg1_, long jarg2);
  public final static native long DataStreamPipeline_pid_first_get(long jarg1, DataStreamPipeline jarg1_);
  public final static native void DataStreamPipeline_pid_last_set(long jarg1, DataStreamPipeline jarg1_, long jarg2);
  public final static native long DataStreamPipeline_pid_last_get(long jarg1, DataStreamPipeline jarg1_);
  public final static native void DataStreamPipeline_closed_set(long jarg1, DataStreamPipeline jarg1_, boolean jarg2);
  public final static native boolean DataStreamPipeline_closed_get(long jarg1, DataStreamPipeline jarg1_);
  public final static native void delete_DataStreamPipeline(long jarg1);
  public final static native boolean process_spawner_init();
  public final static native boolean PROCESS_SPAWNER_INITIALIZER_get();
  public final static native String get_pipeline_cmd(String jarg1, int jarg2);
  public final static native long run_pipeline_cmd(String jarg1, int jarg2, int jarg3);
  public final static native long BIT_MASKS_get();
  public final static native String KMER_BLOOM_FILTER_MAGIC_HEADER_get();
  public final static native String SEED_BLOOM_FILTER_MAGIC_HEADER_get();
  public final static native long pop_cnt_byte(long jarg1);
  public final static native long new_BloomFilter__SWIG_0();
  public final static native long new_BloomFilter__SWIG_1(long jarg1, long jarg2);
  public final static native long new_BloomFilter__SWIG_2(String jarg1);
  public final static native void delete_BloomFilter(long jarg1);
  public final static native void BloomFilter_insert__SWIG_0(long jarg1, BloomFilter jarg1_, long jarg2);
  public final static native void BloomFilter_insert__SWIG_1(long jarg1, BloomFilter jarg1_, long jarg2);
  public final static native boolean BloomFilter_contains__SWIG_0(long jarg1, BloomFilter jarg1_, long jarg2);
  public final static native boolean BloomFilter_contains__SWIG_1(long jarg1, BloomFilter jarg1_, long jarg2);
  public final static native long BloomFilter_get_bytes(long jarg1, BloomFilter jarg1_);
  public final static native long BloomFilter_get_pop_cnt(long jarg1, BloomFilter jarg1_);
  public final static native double BloomFilter_get_occupancy(long jarg1, BloomFilter jarg1_);
  public final static native long BloomFilter_get_hash_num(long jarg1, BloomFilter jarg1_);
  public final static native double BloomFilter_get_fpr(long jarg1, BloomFilter jarg1_);
  public final static native long BloomFilter_parse_header(long jarg1, String jarg2);
  public final static native void BloomFilter_write(long jarg1, BloomFilter jarg1_, String jarg2);
  public final static native long new_KmerBloomFilter__SWIG_0();
  public final static native long new_KmerBloomFilter__SWIG_1(long jarg1, long jarg2, long jarg3);
  public final static native long new_KmerBloomFilter__SWIG_2(String jarg1);
  public final static native void KmerBloomFilter_insert__SWIG_0(long jarg1, KmerBloomFilter jarg1_, String jarg2, long jarg3);
  public final static native void KmerBloomFilter_insert__SWIG_1(long jarg1, KmerBloomFilter jarg1_, String jarg2);
  public final static native long KmerBloomFilter_contains__SWIG_0(long jarg1, KmerBloomFilter jarg1_, String jarg2, long jarg3);
  public final static native long KmerBloomFilter_contains__SWIG_1(long jarg1, KmerBloomFilter jarg1_, String jarg2);
  public final static native boolean KmerBloomFilter_contains__SWIG_2(long jarg1, KmerBloomFilter jarg1_, long jarg2);
  public final static native boolean KmerBloomFilter_contains__SWIG_3(long jarg1, KmerBloomFilter jarg1_, long jarg2);
  public final static native long KmerBloomFilter_get_bytes(long jarg1, KmerBloomFilter jarg1_);
  public final static native long KmerBloomFilter_get_pop_cnt(long jarg1, KmerBloomFilter jarg1_);
  public final static native double KmerBloomFilter_get_occupancy(long jarg1, KmerBloomFilter jarg1_);
  public final static native long KmerBloomFilter_get_hash_num(long jarg1, KmerBloomFilter jarg1_);
  public final static native double KmerBloomFilter_get_fpr(long jarg1, KmerBloomFilter jarg1_);
  public final static native long KmerBloomFilter_get_k(long jarg1, KmerBloomFilter jarg1_);
  public final static native long KmerBloomFilter_get_bloom_filter(long jarg1, KmerBloomFilter jarg1_);
  public final static native void KmerBloomFilter_write(long jarg1, KmerBloomFilter jarg1_, String jarg2);
  public final static native void delete_KmerBloomFilter(long jarg1);
  public final static native long new_SeedBloomFilter__SWIG_0();
  public final static native long new_SeedBloomFilter__SWIG_1(long jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long new_SeedBloomFilter__SWIG_2(String jarg1);
  public final static native void SeedBloomFilter_insert__SWIG_0(long jarg1, SeedBloomFilter jarg1_, String jarg2, long jarg3);
  public final static native void SeedBloomFilter_insert__SWIG_1(long jarg1, SeedBloomFilter jarg1_, String jarg2);
  public final static native long SeedBloomFilter_contains__SWIG_0(long jarg1, SeedBloomFilter jarg1_, String jarg2, long jarg3);
  public final static native long SeedBloomFilter_contains__SWIG_1(long jarg1, SeedBloomFilter jarg1_, String jarg2);
  public final static native boolean SeedBloomFilter_contains__SWIG_2(long jarg1, SeedBloomFilter jarg1_, long jarg2);
  public final static native boolean SeedBloomFilter_contains__SWIG_3(long jarg1, SeedBloomFilter jarg1_, long jarg2);
  public final static native long SeedBloomFilter_get_bytes(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_pop_cnt(long jarg1, SeedBloomFilter jarg1_);
  public final static native double SeedBloomFilter_get_occupancy(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_hash_num(long jarg1, SeedBloomFilter jarg1_);
  public final static native double SeedBloomFilter_get_fpr(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_k(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_seeds(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_parsed_seeds(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_hash_num_per_seed(long jarg1, SeedBloomFilter jarg1_);
  public final static native long SeedBloomFilter_get_kmer_bloom_filter(long jarg1, SeedBloomFilter jarg1_);
  public final static native void SeedBloomFilter_write(long jarg1, SeedBloomFilter jarg1_, String jarg2);
  public final static native void delete_SeedBloomFilter(long jarg1);
  public final static native long SeqReader_Flag_FOLD_CASE_get();
  public final static native long SeqReader_Flag_NO_FOLD_CASE_get();
  public final static native long SeqReader_Flag_NO_TRIM_MASKED_get();
  public final static native long SeqReader_Flag_TRIM_MASKED_get();
  public final static native long new_SeqReader_Flag();
  public final static native void delete_SeqReader_Flag(long jarg1);
  public final static native long new_SeqReader__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_SeqReader__SWIG_1(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long new_SeqReader__SWIG_2(String jarg1, long jarg2, long jarg3);
  public final static native long new_SeqReader__SWIG_3(String jarg1, long jarg2);
  public final static native long new_SeqReader__SWIG_4(String jarg1);
  public final static native void delete_SeqReader(long jarg1);
  public final static native void SeqReader_close(long jarg1, SeqReader jarg1_);
  public final static native boolean SeqReader_fold_case(long jarg1, SeqReader jarg1_);
  public final static native boolean SeqReader_trim_masked(long jarg1, SeqReader jarg1_);
  public final static native int SeqReader_get_format(long jarg1, SeqReader jarg1_);
  public final static native void SeqReader_Record_num_set(long jarg1, SeqReader.Record jarg1_, long jarg2);
  public final static native long SeqReader_Record_num_get(long jarg1, SeqReader.Record jarg1_);
  public final static native void SeqReader_Record_name_set(long jarg1, SeqReader.Record jarg1_, String jarg2);
  public final static native String SeqReader_Record_name_get(long jarg1, SeqReader.Record jarg1_);
  public final static native void SeqReader_Record_comment_set(long jarg1, SeqReader.Record jarg1_, String jarg2);
  public final static native String SeqReader_Record_comment_get(long jarg1, SeqReader.Record jarg1_);
  public final static native void SeqReader_Record_seq_set(long jarg1, SeqReader.Record jarg1_, String jarg2);
  public final static native String SeqReader_Record_seq_get(long jarg1, SeqReader.Record jarg1_);
  public final static native void SeqReader_Record_qual_set(long jarg1, SeqReader.Record jarg1_, String jarg2);
  public final static native String SeqReader_Record_qual_get(long jarg1, SeqReader.Record jarg1_);
  public final static native long new_SeqReader_Record();
  public final static native void delete_SeqReader_Record(long jarg1);
  public final static native long SeqReader_read(long jarg1, SeqReader jarg1_);
  public final static native long SeqReader_MAX_SIMULTANEOUS_SEQREADERS_get();
  public final static native long Indexlr_Flag_ID_get();
  public final static native long Indexlr_Flag_NO_ID_get();
  public final static native long Indexlr_Flag_BX_get();
  public final static native long Indexlr_Flag_NO_BX_get();
  public final static native long Indexlr_Flag_SEQ_get();
  public final static native long Indexlr_Flag_NO_SEQ_get();
  public final static native long Indexlr_Flag_FILTER_IN_get();
  public final static native long Indexlr_Flag_NO_FILTER_IN_get();
  public final static native long Indexlr_Flag_FILTER_OUT_get();
  public final static native long Indexlr_Flag_NO_FILTER_OUT_get();
  public final static native long Indexlr_Flag_SHORT_MODE_get();
  public final static native long Indexlr_Flag_LONG_MODE_get();
  public final static native long new_Indexlr_Flag();
  public final static native void delete_Indexlr_Flag(long jarg1);
  public final static native boolean Indexlr_output_id(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_output_bx(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_output_seq(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_filter_in(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_filter_out(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_short_mode(long jarg1, Indexlr jarg1_);
  public final static native boolean Indexlr_long_mode(long jarg1, Indexlr jarg1_);
  public final static native long new_Indexlr_Read__SWIG_0();
  public final static native long new_Indexlr_Read__SWIG_1(long jarg1, String jarg2, String jarg3, String jarg4);
  public final static native void Indexlr_Read_num_set(long jarg1, Indexlr.Read jarg1_, long jarg2);
  public final static native long Indexlr_Read_num_get(long jarg1, Indexlr.Read jarg1_);
  public final static native void Indexlr_Read_id_set(long jarg1, Indexlr.Read jarg1_, String jarg2);
  public final static native String Indexlr_Read_id_get(long jarg1, Indexlr.Read jarg1_);
  public final static native void Indexlr_Read_comment_set(long jarg1, Indexlr.Read jarg1_, String jarg2);
  public final static native String Indexlr_Read_comment_get(long jarg1, Indexlr.Read jarg1_);
  public final static native void Indexlr_Read_seq_set(long jarg1, Indexlr.Read jarg1_, String jarg2);
  public final static native String Indexlr_Read_seq_get(long jarg1, Indexlr.Read jarg1_);
  public final static native void delete_Indexlr_Read(long jarg1);
  public final static native long new_Indexlr_Minimizer__SWIG_0();
  public final static native long new_Indexlr_Minimizer__SWIG_1(long jarg1, long jarg2, long jarg3, boolean jarg4, String jarg5);
  public final static native void Indexlr_Minimizer_min_hash_set(long jarg1, Indexlr.Minimizer jarg1_, long jarg2);
  public final static native long Indexlr_Minimizer_min_hash_get(long jarg1, Indexlr.Minimizer jarg1_);
  public final static native void Indexlr_Minimizer_out_hash_set(long jarg1, Indexlr.Minimizer jarg1_, long jarg2);
  public final static native long Indexlr_Minimizer_out_hash_get(long jarg1, Indexlr.Minimizer jarg1_);
  public final static native void Indexlr_Minimizer_pos_set(long jarg1, Indexlr.Minimizer jarg1_, long jarg2);
  public final static native long Indexlr_Minimizer_pos_get(long jarg1, Indexlr.Minimizer jarg1_);
  public final static native void Indexlr_Minimizer_forward_set(long jarg1, Indexlr.Minimizer jarg1_, boolean jarg2);
  public final static native boolean Indexlr_Minimizer_forward_get(long jarg1, Indexlr.Minimizer jarg1_);
  public final static native void Indexlr_Minimizer_seq_set(long jarg1, Indexlr.Minimizer jarg1_, String jarg2);
  public final static native String Indexlr_Minimizer_seq_get(long jarg1, Indexlr.Minimizer jarg1_);
  public final static native void delete_Indexlr_Minimizer(long jarg1);
  public final static native long new_Indexlr_Record__SWIG_0();
  public final static native long new_Indexlr_Record__SWIG_1(long jarg1, String jarg2, String jarg3, long jarg4);
  public final static native void Indexlr_Record_num_set(long jarg1, Indexlr.Record jarg1_, long jarg2);
  public final static native long Indexlr_Record_num_get(long jarg1, Indexlr.Record jarg1_);
  public final static native void Indexlr_Record_id_set(long jarg1, Indexlr.Record jarg1_, String jarg2);
  public final static native String Indexlr_Record_id_get(long jarg1, Indexlr.Record jarg1_);
  public final static native void Indexlr_Record_barcode_set(long jarg1, Indexlr.Record jarg1_, String jarg2);
  public final static native String Indexlr_Record_barcode_get(long jarg1, Indexlr.Record jarg1_);
  public final static native void Indexlr_Record_minimizers_set(long jarg1, Indexlr.Record jarg1_, long jarg2);
  public final static native long Indexlr_Record_minimizers_get(long jarg1, Indexlr.Record jarg1_);
  public final static native void delete_Indexlr_Record(long jarg1);
  public final static native long Indexlr_get_minimizers(long jarg1, Indexlr jarg1_);
  public final static native long new_Indexlr__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, boolean jarg6, long jarg7, BloomFilter jarg7_, long jarg8, BloomFilter jarg8_);
  public final static native long new_Indexlr__SWIG_1(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, boolean jarg6, long jarg7, BloomFilter jarg7_);
  public final static native long new_Indexlr__SWIG_2(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, boolean jarg6);
  public final static native long new_Indexlr__SWIG_3(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_Indexlr__SWIG_4(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long new_Indexlr__SWIG_5(String jarg1, long jarg2, long jarg3);
  public final static native void delete_Indexlr(long jarg1);
  public final static native long Indexlr_MAX_SIMULTANEOUS_INDEXLRS_get();
  public final static native long Indexlr_SHORT_MODE_BUFFER_SIZE_get();
  public final static native long Indexlr_SHORT_MODE_BLOCK_SIZE_get();
  public final static native long Indexlr_LONG_MODE_BUFFER_SIZE_get();
  public final static native long Indexlr_LONG_MODE_BLOCK_SIZE_get();
  public final static native long split(String jarg1, String jarg2);
  public final static native void ltrim(long jarg1);
  public final static native void rtrim(long jarg1);
  public final static native void trim(long jarg1);
  public final static native boolean starts_with(String jarg1, String jarg2);
  public final static native boolean ends_with(String jarg1, String jarg2);
  public final static native String COMPLEMENTS_get();
  public final static native String CAPITALS_get();
  public final static native void reverse_complement(long jarg1);
  public final static native String get_reverse_complement(String jarg1);
  public final static native long CP_OFF_get();
  public final static native int MULTISHIFT_get();
  public final static native long MULTISEED_get();
  public final static native long SEED_A_get();
  public final static native long SEED_C_get();
  public final static native long SEED_G_get();
  public final static native long SEED_T_get();
  public final static native long SEED_N_get();
  public final static native int ASCII_SIZE_get();
  public final static native long SEED_TAB_get();
  public final static native long A33R_get();
  public final static native long A31L_get();
  public final static native long C33R_get();
  public final static native long C31L_get();
  public final static native long G33R_get();
  public final static native long G31L_get();
  public final static native long T33R_get();
  public final static native long T31L_get();
  public final static native long N33R_get();
  public final static native long N31L_get();
  public final static native long MS_TAB_33R_get();
  public final static native long MS_TAB_31L_get();
  public final static native long RC_CONVERT_TAB_get();
  public final static native long CONVERT_TAB_get();
  public final static native long DIMER_TAB_get();
  public final static native long TRIMER_TAB_get();
  public final static native long TETRAMER_TAB_get();
  public final static native long rol1(long jarg1);
  public final static native long rolx(long jarg1, long jarg2);
  public final static native long ror1(long jarg1);
  public final static native long rol31(long jarg1, long jarg2);
  public final static native long rol33(long jarg1, long jarg2);
  public final static native long swapbits033(long jarg1);
  public final static native long swapbits3263(long jarg1);
  public final static native long swapxbits033(long jarg1, long jarg2);
  public final static native long ntf64__SWIG_0(String jarg1, long jarg2);
  public final static native long ntr64__SWIG_0(String jarg1, long jarg2);
  public final static native long ntf64__SWIG_1(long jarg1, long jarg2, short jarg3, short jarg4);
  public final static native long ntr64__SWIG_1(long jarg1, long jarg2, short jarg3, short jarg4);
  public final static native long ntc64__SWIG_0(String jarg1, long jarg2);
  public final static native long ntc64__SWIG_1(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long ntc64__SWIG_2(short jarg1, short jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long ntf64l(long jarg1, long jarg2, short jarg3, short jarg4);
  public final static native long ntr64l(long jarg1, long jarg2, short jarg3, short jarg4);
  public final static native long ntc64l(short jarg1, short jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long ntf64__SWIG_2(String jarg1, long jarg2, long jarg3);
  public final static native long ntc64__SWIG_3(String jarg1, long jarg2, long jarg3);
  public final static native void ntm64__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long nte64(long jarg1, long jarg2, long jarg3);
  public final static native void ntm64__SWIG_1(short jarg1, short jarg2, long jarg3, long jarg4, long jarg5);
  public final static native void ntmc64__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native void ntmc64__SWIG_1(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6);
  public final static native void ntmc64__SWIG_2(short jarg1, short jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7);
  public final static native boolean ntc64__SWIG_4(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native boolean ntmc64__SWIG_3(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native boolean ntc64__SWIG_5(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6);
  public final static native boolean ntmc64__SWIG_4(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7);
  public final static native boolean ntmc64__SWIG_5(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7, long jarg8);
  public final static native void ntmc64__SWIG_6(short jarg1, short jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7, long jarg8);
  public final static native long mask_hash(long jarg1, long jarg2, String jarg3, String jarg4, long jarg5);
  public final static native void sub_hash(long jarg1, long jarg2, String jarg3, long jarg4, long jarg5, long jarg6, long jarg7, long jarg8);
  public final static native long nts64__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long nts64__SWIG_1(String jarg1, long jarg2, short jarg3, short jarg4, long jarg5, long jarg6);
  public final static native boolean ntms64__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7, long jarg8, long jarg9);
  public final static native void ntms64__SWIG_1(String jarg1, long jarg2, short jarg3, short jarg4, long jarg5, long jarg6, long jarg7, long jarg8, long jarg9, long jarg10);
  public final static native boolean ntmsm64__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7, long jarg8, long jarg9);
  public final static native void ntmsm64__SWIG_1(String jarg1, long jarg2, short jarg3, short jarg4, long jarg5, long jarg6, long jarg7, long jarg8, long jarg9, long jarg10);
  public final static native long parse_seeds(long jarg1);
  public final static native long new_NtHash__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long new_NtHash__SWIG_1(String jarg1, long jarg2, long jarg3);
  public final static native boolean NtHash_roll(long jarg1, NtHash jarg1_);
  public final static native void NtHash_sub(long jarg1, NtHash jarg1_, long jarg2, long jarg3);
  public final static native long NtHash_hashes(long jarg1, NtHash jarg1_);
  public final static native long NtHash_get_pos(long jarg1, NtHash jarg1_);
  public final static native boolean NtHash_forward(long jarg1, NtHash jarg1_);
  public final static native long NtHash_get_k(long jarg1, NtHash jarg1_);
  public final static native long NtHash_get_hash_num(long jarg1, NtHash jarg1_);
  public final static native void delete_NtHash(long jarg1);
  public final static native long new_SeedNtHash__SWIG_0(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6);
  public final static native long new_SeedNtHash__SWIG_1(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_SeedNtHash__SWIG_2(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_SeedNtHash__SWIG_3(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long new_SeedNtHash__SWIG_4(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6);
  public final static native long new_SeedNtHash__SWIG_5(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_SeedNtHash__SWIG_6(String jarg1, long jarg2, long jarg3, long jarg4, long jarg5);
  public final static native long new_SeedNtHash__SWIG_7(String jarg1, long jarg2, long jarg3, long jarg4);
  public final static native long SeedNtHash_hashes(long jarg1, SeedNtHash jarg1_);
  public final static native long SeedNtHash_get_pos(long jarg1, SeedNtHash jarg1_);
  public final static native boolean SeedNtHash_forward(long jarg1, SeedNtHash jarg1_);
  public final static native long SeedNtHash_get_k(long jarg1, SeedNtHash jarg1_);
  public final static native long SeedNtHash_get_hash_num(long jarg1, SeedNtHash jarg1_);
  public final static native long SeedNtHash_get_hash_num_per_seed(long jarg1, SeedNtHash jarg1_);
  public final static native boolean SeedNtHash_roll(long jarg1, SeedNtHash jarg1_);
  public final static native void delete_SeedNtHash(long jarg1);
  public final static native String get_time();
  public final static native void log_info(String jarg1);
  public final static native void log_warning(String jarg1);
  public final static native void log_error(String jarg1);
  public final static native void check_info(boolean jarg1, String jarg2);
  public final static native void check_warning(boolean jarg1, String jarg2);
  public final static native void check_error(boolean jarg1, String jarg2);
  public final static native void check_stream(long jarg1, String jarg2);
  public final static native long DataSource_SWIGUpcast(long jarg1);
  public final static native long DataSink_SWIGUpcast(long jarg1);
}
