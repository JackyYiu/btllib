# This file was automatically generated by SWIG (http://www.swig.org).
# Version 4.0.0
#
# Do not make changes to this file unless you know what you are doing--modify
# the SWIG interface file instead.

from sys import version_info as _swig_python_version_info
if _swig_python_version_info < (2, 7, 0):
    raise RuntimeError('Python 2.7 or later required')

# Import the low-level C/C++ module
if __package__ or '.' in __name__:
    from . import _btl
else:
    import _btl

try:
    import builtins as __builtin__
except ImportError:
    import __builtin__

def _swig_setattr_nondynamic(self, class_type, name, value, static=1):
    if name == "thisown":
        return self.this.own(value)
    if name == "this":
        if type(value).__name__ == 'SwigPyObject':
            self.__dict__[name] = value
            return
    method = class_type.__swig_setmethods__.get(name, None)
    if method:
        return method(self, value)
    if not static:
        object.__setattr__(self, name, value)
    else:
        raise AttributeError("You cannot add attributes to %s" % self)


def _swig_setattr(self, class_type, name, value):
    return _swig_setattr_nondynamic(self, class_type, name, value, 0)


def _swig_getattr(self, class_type, name):
    if name == "thisown":
        return self.this.own()
    method = class_type.__swig_getmethods__.get(name, None)
    if method:
        return method(self)
    raise AttributeError("'%s' object has no attribute '%s'" % (class_type.__name__, name))


def _swig_repr(self):
    try:
        strthis = "proxy of " + self.this.__repr__()
    except __builtin__.Exception:
        strthis = ""
    return "<%s.%s; %s >" % (self.__class__.__module__, self.__class__.__name__, strthis,)


def _swig_setattr_nondynamic_instance_variable(set):
    def set_instance_attr(self, name, value):
        if name == "thisown":
            self.this.own(value)
        elif name == "this":
            set(self, name, value)
        elif hasattr(self, name) and isinstance(getattr(type(self), name), property):
            set(self, name, value)
        else:
            raise AttributeError("You cannot add instance attributes to %s" % self)
    return set_instance_attr


def _swig_setattr_nondynamic_class_variable(set):
    def set_class_attr(cls, name, value):
        if hasattr(cls, name) and not isinstance(getattr(cls, name), property):
            set(cls, name, value)
        else:
            raise AttributeError("You cannot add class attributes to %s" % cls)
    return set_class_attr


def _swig_add_metaclass(metaclass):
    """Class decorator for adding a metaclass to a SWIG wrapped class - a slimmed down version of six.add_metaclass"""
    def wrapper(cls):
        return metaclass(cls.__name__, cls.__bases__, cls.__dict__.copy())
    return wrapper


class _SwigNonDynamicMeta(type):
    """Meta class to enforce nondynamic attributes (no new attributes) for a class"""
    __setattr__ = _swig_setattr_nondynamic_class_variable(type.__setattr__)


class ios_base(object):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')

    def __init__(self, *args, **kwargs):
        raise AttributeError("No constructor defined")
    __repr__ = _swig_repr
    erase_event = _btl.ios_base_erase_event
    imbue_event = _btl.ios_base_imbue_event
    copyfmt_event = _btl.ios_base_copyfmt_event

    def register_callback(self, __fn: 'std::ios_base::event_callback', __index: 'int') -> "void":
        return _btl.ios_base_register_callback(self, __fn, __index)

    def flags(self, *args) -> "std::ios_base::fmtflags":
        return _btl.ios_base_flags(self, *args)

    def setf(self, *args) -> "std::ios_base::fmtflags":
        return _btl.ios_base_setf(self, *args)

    def unsetf(self, __mask: 'std::ios_base::fmtflags') -> "void":
        return _btl.ios_base_unsetf(self, __mask)

    def precision(self, *args) -> "std::streamsize":
        return _btl.ios_base_precision(self, *args)

    def width(self, *args) -> "std::streamsize":
        return _btl.ios_base_width(self, *args)

    @staticmethod
    def sync_with_stdio(__sync: 'bool'=True) -> "bool":
        return _btl.ios_base_sync_with_stdio(__sync)

    def imbue(self, __loc: 'std::locale const &') -> "std::locale":
        return _btl.ios_base_imbue(self, __loc)

    def getloc(self) -> "std::locale":
        return _btl.ios_base_getloc(self)

    @staticmethod
    def xalloc() -> "int":
        return _btl.ios_base_xalloc()

    def iword(self, __ix: 'int') -> "long &":
        return _btl.ios_base_iword(self, __ix)

    def pword(self, __ix: 'int') -> "void *&":
        return _btl.ios_base_pword(self, __ix)
    __swig_destroy__ = _btl.delete_ios_base

# Register ios_base in _btl:
_btl.ios_base_swigregister(ios_base)
cvar = _btl.cvar
ios_base.boolalpha = _btl.cvar.ios_base_boolalpha
ios_base.dec = _btl.cvar.ios_base_dec
ios_base.fixed = _btl.cvar.ios_base_fixed
ios_base.hex = _btl.cvar.ios_base_hex
ios_base.internal = _btl.cvar.ios_base_internal
ios_base.left = _btl.cvar.ios_base_left
ios_base.oct = _btl.cvar.ios_base_oct
ios_base.right = _btl.cvar.ios_base_right
ios_base.scientific = _btl.cvar.ios_base_scientific
ios_base.showbase = _btl.cvar.ios_base_showbase
ios_base.showpoint = _btl.cvar.ios_base_showpoint
ios_base.showpos = _btl.cvar.ios_base_showpos
ios_base.skipws = _btl.cvar.ios_base_skipws
ios_base.unitbuf = _btl.cvar.ios_base_unitbuf
ios_base.uppercase = _btl.cvar.ios_base_uppercase
ios_base.adjustfield = _btl.cvar.ios_base_adjustfield
ios_base.basefield = _btl.cvar.ios_base_basefield
ios_base.floatfield = _btl.cvar.ios_base_floatfield
ios_base.badbit = _btl.cvar.ios_base_badbit
ios_base.eofbit = _btl.cvar.ios_base_eofbit
ios_base.failbit = _btl.cvar.ios_base_failbit
ios_base.goodbit = _btl.cvar.ios_base_goodbit
ios_base.app = _btl.cvar.ios_base_app
ios_base.ate = _btl.cvar.ios_base_ate
ios_base.binary = _btl.cvar.ios_base_binary
ios_base.ios_base_in = _btl.cvar.ios_base_ios_base_in
ios_base.out = _btl.cvar.ios_base_out
ios_base.trunc = _btl.cvar.ios_base_trunc
ios_base.beg = _btl.cvar.ios_base_beg
ios_base.cur = _btl.cvar.ios_base_cur
ios_base.end = _btl.cvar.ios_base_end

def ios_base_sync_with_stdio(__sync: 'bool'=True) -> "bool":
    return _btl.ios_base_sync_with_stdio(__sync)

def ios_base_xalloc() -> "int":
    return _btl.ios_base_xalloc()

class ios(ios_base):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr

    def rdstate(self) -> "std::ios_base::iostate":
        return _btl.ios_rdstate(self)

    def clear(self, *args) -> "void":
        return _btl.ios_clear(self, *args)

    def setstate(self, __state: 'std::ios_base::iostate') -> "void":
        return _btl.ios_setstate(self, __state)

    def good(self) -> "bool":
        return _btl.ios_good(self)

    def eof(self) -> "bool":
        return _btl.ios_eof(self)

    def fail(self) -> "bool":
        return _btl.ios_fail(self)

    def bad(self) -> "bool":
        return _btl.ios_bad(self)

    def exceptions(self, *args) -> "void":
        return _btl.ios_exceptions(self, *args)

    def __init__(self, __sb: 'std::basic_streambuf< char,std::char_traits< char > > *'):
        _btl.ios_swiginit(self, _btl.new_ios(__sb))
    __swig_destroy__ = _btl.delete_ios

    def tie(self, *args) -> "std::basic_ostream< char,std::char_traits< char > > *":
        return _btl.ios_tie(self, *args)

    def rdbuf(self, *args) -> "std::basic_streambuf< char,std::char_traits< char > > *":
        return _btl.ios_rdbuf(self, *args)

    def copyfmt(self, __rhs: 'ios') -> "std::basic_ios< char > &":
        return _btl.ios_copyfmt(self, __rhs)

    def fill(self, *args) -> "std::basic_ios< char >::char_type":
        return _btl.ios_fill(self, *args)

    def imbue(self, __loc: 'std::locale const &') -> "std::locale":
        return _btl.ios_imbue(self, __loc)

    def narrow(self, __c: 'std::basic_ios< char >::char_type', __dfault: 'char') -> "char":
        return _btl.ios_narrow(self, __c, __dfault)

    def widen(self, __c: 'char') -> "std::basic_ios< char >::char_type":
        return _btl.ios_widen(self, __c)

# Register ios in _btl:
_btl.ios_swigregister(ios)

class ostream(ios):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr

    def __init__(self, __sb: 'std::basic_streambuf< char,std::char_traits< char > > *'):
        _btl.ostream_swiginit(self, _btl.new_ostream(__sb))
    __swig_destroy__ = _btl.delete_ostream

    def __lshift__(self, *args) -> "std::basic_ostream< char,std::char_traits< char > > &":
        return _btl.ostream___lshift__(self, *args)

    def put(self, __c: 'std::basic_ostream< char >::char_type') -> "std::basic_ostream< char,std::char_traits< char > > &":
        return _btl.ostream_put(self, __c)

    def write(self, __s: 'std::basic_ostream< char >::char_type const *', __n: 'std::streamsize') -> "std::basic_ostream< char,std::char_traits< char > > &":
        return _btl.ostream_write(self, __s, __n)

    def flush(self) -> "std::basic_ostream< char,std::char_traits< char > > &":
        return _btl.ostream_flush(self)

    def tellp(self) -> "std::basic_ostream< char >::pos_type":
        return _btl.ostream_tellp(self)

    def seekp(self, *args) -> "std::basic_ostream< char,std::char_traits< char > > &":
        return _btl.ostream_seekp(self, *args)

# Register ostream in _btl:
_btl.ostream_swigregister(ostream)
cin = cvar.cin
cout = cvar.cout
cerr = cvar.cerr
clog = cvar.clog

class istream(ios):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr

    def __init__(self, __sb: 'std::basic_streambuf< char,std::char_traits< char > > *'):
        _btl.istream_swiginit(self, _btl.new_istream(__sb))
    __swig_destroy__ = _btl.delete_istream

    def __rshift__(self, *args) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream___rshift__(self, *args)

    def gcount(self) -> "std::streamsize":
        return _btl.istream_gcount(self)

    def get(self, *args) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_get(self, *args)

    def getline(self, *args) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_getline(self, *args)

    def ignore(self, *args) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_ignore(self, *args)

    def peek(self) -> "std::basic_istream< char >::int_type":
        return _btl.istream_peek(self)

    def read(self, __s: 'std::basic_istream< char >::char_type *', __n: 'std::streamsize') -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_read(self, __s, __n)

    def readsome(self, __s: 'std::basic_istream< char >::char_type *', __n: 'std::streamsize') -> "std::streamsize":
        return _btl.istream_readsome(self, __s, __n)

    def putback(self, __c: 'std::basic_istream< char >::char_type') -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_putback(self, __c)

    def unget(self) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_unget(self)

    def sync(self) -> "int":
        return _btl.istream_sync(self)

    def tellg(self) -> "std::basic_istream< char >::pos_type":
        return _btl.istream_tellg(self)

    def seekg(self, *args) -> "std::basic_istream< char,std::char_traits< char > > &":
        return _btl.istream_seekg(self, *args)

# Register istream in _btl:
_btl.istream_swigregister(istream)

class iostream(istream, ostream):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr

    def __init__(self, __sb: 'std::basic_streambuf< char,std::char_traits< char > > *'):
        _btl.iostream_swiginit(self, _btl.new_iostream(__sb))
    __swig_destroy__ = _btl.delete_iostream

# Register iostream in _btl:
_btl.iostream_swigregister(iostream)

endl_cb_ptr = _btl.endl_cb_ptr
endl = _btl.endl
ends_cb_ptr = _btl.ends_cb_ptr
ends = _btl.ends
flush_cb_ptr = _btl.flush_cb_ptr
flush = _btl.flush
class Sequence(object):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr
    npos = _btl.Sequence_npos

    def __init__(self, *args):
        _btl.Sequence_swiginit(self, _btl.new_Sequence(*args))
    __swig_destroy__ = _btl.delete_Sequence

    def begin(self, *args) -> "btl::Sequence::const_iterator":
        return _btl.Sequence_begin(self, *args)

    def end(self, *args) -> "btl::Sequence::const_iterator":
        return _btl.Sequence_end(self, *args)

    def rbegin(self, *args) -> "btl::Sequence::const_reverse_iterator":
        return _btl.Sequence_rbegin(self, *args)

    def rend(self, *args) -> "btl::Sequence::const_reverse_iterator":
        return _btl.Sequence_rend(self, *args)

    def cbegin(self) -> "btl::Sequence::const_iterator":
        return _btl.Sequence_cbegin(self)

    def cend(self) -> "btl::Sequence::const_iterator":
        return _btl.Sequence_cend(self)

    def crbegin(self) -> "btl::Sequence::const_reverse_iterator":
        return _btl.Sequence_crbegin(self)

    def crend(self) -> "btl::Sequence::const_reverse_iterator":
        return _btl.Sequence_crend(self)

    def size(self) -> "size_t":
        return _btl.Sequence_size(self)

    def length(self) -> "size_t":
        return _btl.Sequence_length(self)

    def max_size(self) -> "size_t":
        return _btl.Sequence_max_size(self)

    def resize(self, *args) -> "void":
        return _btl.Sequence_resize(self, *args)

    def capacity(self) -> "size_t":
        return _btl.Sequence_capacity(self)

    def reserve(self, n: 'size_t'=0) -> "void":
        return _btl.Sequence_reserve(self, n)

    def clear(self) -> "void":
        return _btl.Sequence_clear(self)

    def empty(self) -> "bool":
        return _btl.Sequence_empty(self)

    def shrink_to_fit(self) -> "void":
        return _btl.Sequence_shrink_to_fit(self)

    def at(self, pos: 'size_t') -> "btl::Sequence::Base":
        return _btl.Sequence_at(self, pos)

    def back(self) -> "btl::Sequence::Base":
        return _btl.Sequence_back(self)

    def front(self) -> "btl::Sequence::Base":
        return _btl.Sequence_front(self)

    def __iadd__(self, *args) -> "btl::Sequence &":
        return _btl.Sequence___iadd__(self, *args)

    def append(self, *args) -> "btl::Sequence &":
        return _btl.Sequence_append(self, *args)

    def push_back(self, base: 'char') -> "void":
        return _btl.Sequence_push_back(self, base)

    def assign(self, *args) -> "btl::Sequence &":
        return _btl.Sequence_assign(self, *args)

    def insert(self, *args) -> "btl::Sequence::iterator":
        return _btl.Sequence_insert(self, *args)

    def erase(self, *args) -> "btl::Sequence::iterator":
        return _btl.Sequence_erase(self, *args)

    def replace(self, *args) -> "btl::Sequence &":
        return _btl.Sequence_replace(self, *args)

    def swap(self, *args) -> "void":
        return _btl.Sequence_swap(self, *args)

    def pop_back(self) -> "void":
        return _btl.Sequence_pop_back(self)

    def c_str(self) -> "char const *":
        return _btl.Sequence_c_str(self)

    def data(self) -> "char const *":
        return _btl.Sequence_data(self)

    def get_allocator(self) -> "btl::Sequence::allocator_type":
        return _btl.Sequence_get_allocator(self)

    def copy(self, bases: 'char *', len: 'size_t', pos: 'size_t'=0) -> "size_t":
        return _btl.Sequence_copy(self, bases, len, pos)

    def find(self, *args) -> "size_t":
        return _btl.Sequence_find(self, *args)

    def rfind(self, *args) -> "size_t":
        return _btl.Sequence_rfind(self, *args)

    def find_first_of(self, *args) -> "size_t":
        return _btl.Sequence_find_first_of(self, *args)

    def find_last_of(self, *args) -> "size_t":
        return _btl.Sequence_find_last_of(self, *args)

    def find_first_not_of(self, *args) -> "size_t":
        return _btl.Sequence_find_first_not_of(self, *args)

    def find_last_not_of(self, *args) -> "size_t":
        return _btl.Sequence_find_last_not_of(self, *args)

    def substr(self, *args) -> "btl::Sequence":
        return _btl.Sequence_substr(self, *args)

    def compare(self, *args) -> "int":
        return _btl.Sequence_compare(self, *args)

    def reverseComplement(self) -> "void":
        return _btl.Sequence_reverseComplement(self)

    def getReverseComplement(self) -> "btl::Sequence":
        return _btl.Sequence_getReverseComplement(self)

    def __invert__(self) -> "btl::Sequence":
        return _btl.Sequence___invert__(self)

    def __getitem__(self, key: 'size_t') -> "char":
        return _btl.Sequence___getitem__(self, key)

    def __setitem__(self, key: 'size_t', value: 'char') -> "void":
        return _btl.Sequence___setitem__(self, key, value)

    def __str__(self) -> "std::string":
        return _btl.Sequence___str__(self)

    def __add__(self, *args) -> "btl::Sequence":
        return _btl.Sequence___add__(self, *args)

    def __radd__(self, *args) -> "btl::Sequence":
        return _btl.Sequence___radd__(self, *args)

    def __eq__(self, *args) -> "bool":
        return _btl.Sequence___eq__(self, *args)

    def __ne__(self, *args) -> "bool":
        return _btl.Sequence___ne__(self, *args)

    def __gt__(self, *args) -> "bool":
        return _btl.Sequence___gt__(self, *args)

    def __ge__(self, *args) -> "bool":
        return _btl.Sequence___ge__(self, *args)

    def __lt__(self, *args) -> "bool":
        return _btl.Sequence___lt__(self, *args)

    def __le__(self, *args) -> "bool":
        return _btl.Sequence___le__(self, *args)

# Register Sequence in _btl:
_btl.Sequence_swigregister(Sequence)

class Base(object):
    thisown = property(lambda x: x.this.own(), lambda x, v: x.this.own(v), doc='The membership flag')
    __repr__ = _swig_repr

    def __init__(self, *args):
        _btl.Base_swiginit(self, _btl.new_Base(*args))

    def complement(self) -> "void":
        return _btl.Base_complement(self)

    def getComplement(self) -> "char":
        return _btl.Base_getComplement(self)

    def __invert__(self) -> "char":
        return _btl.Base___invert__(self)

    @staticmethod
    def validate(*args) -> "void":
        return _btl.Base_validate(*args)

    @staticmethod
    def capitalize(*args) -> "char":
        return _btl.Base_capitalize(*args)
    b = property(_btl.Base_b_get, _btl.Base_b_set)
    __swig_destroy__ = _btl.delete_Base

# Register Base in _btl:
_btl.Base_swigregister(Base)

def Base_validate(*args) -> "void":
    return _btl.Base_validate(*args)

def Base_capitalize(*args) -> "char":
    return _btl.Base_capitalize(*args)
Base.COMPLEMENTS = _btl.cvar.Base_COMPLEMENTS
Base.CAPITALS = _btl.cvar.Base_CAPITALS


def __eq__(*args) -> "bool":
    return _btl.__eq__(*args)

def __ne__(*args) -> "bool":
    return _btl.__ne__(*args)

def __lt__(*args) -> "bool":
    return _btl.__lt__(*args)

def __le__(*args) -> "bool":
    return _btl.__le__(*args)

def __gt__(*args) -> "bool":
    return _btl.__gt__(*args)

def __ge__(*args) -> "bool":
    return _btl.__ge__(*args)

def __rshift__(_is: 'istream', rhs: 'Sequence') -> "std::istream &":
    return _btl.__rshift__(_is, rhs)

def __lshift__(os: 'ostream', rhs: 'Sequence') -> "std::ostream &":
    return _btl.__lshift__(os, rhs)


