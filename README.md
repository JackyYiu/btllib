BTL common code library in C++ with Python and Java wrappers.

Dependencies
---
- GCC 7.0.0+ or Clang 5.0.0+
- Python 3.5+
- Meson and Ninja Python3 packages (if they are missing, they will be automatically downloaded in a temporary directory)

C++
---
- Copy the libbtl directory in your project
- Use any header from the `btllib/include` directory

Python and Java
---
- Run `btllib/compile`
- The wrappers correspond one-to-one with C++ code so any functions and classes can be used under the same name.
- Python
  * Use Python's `sys.path.append()` to include `btllib/python` directory
  * Include the library with `import btllib`
- Java
  * Add `btllib/java` to classpath
  * Include classes with `import btllib.*`

