/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.0
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class Base {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Base(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Base obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        btlJNI.delete_Base(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void complement() {
    btlJNI.Base_complement(swigCPtr, this);
  }

  public char getComplement() {
    return btlJNI.Base_getComplement(swigCPtr, this);
  }

  public void validate() {
    btlJNI.Base_validate__SWIG_0(swigCPtr, this);
  }

  public void capitalize() {
    btlJNI.Base_capitalize__SWIG_0(swigCPtr, this);
  }

  public static void validate(char base) {
    btlJNI.Base_validate__SWIG_1(base);
  }

  public static char capitalize(char base) {
    return btlJNI.Base_capitalize__SWIG_1(base);
  }

  public Base(SWIGTYPE_p_char base) {
    this(btlJNI.new_Base__SWIG_0(SWIGTYPE_p_char.getCPtr(base)), true);
  }

  public Base(Base base) {
    this(btlJNI.new_Base__SWIG_1(Base.getCPtr(base), base), true);
  }

  public void setB(SWIGTYPE_p_char value) {
    btlJNI.Base_b_set(swigCPtr, this, SWIGTYPE_p_char.getCPtr(value));
  }

  public SWIGTYPE_p_char getB() {
    return new SWIGTYPE_p_char(btlJNI.Base_b_get(swigCPtr, this), false);
  }

  public static String getCOMPLEMENTS() {
    return btlJNI.Base_COMPLEMENTS_get();
  }

  public static String getCAPITALS() {
    return btlJNI.Base_CAPITALS_get();
  }

}
