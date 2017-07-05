# Sets the minimum version of CMake required to build the native
# library. You should either keep the default value or only pass a
# value of 3.4.0 or lower.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds it for you.
# Gradle automatically packages shared libraries with your APK.

aux_source_directory(src/main/cpp DIR_SRCS)
aux_source_directory (src/main/cpp/external EXTERNAL_SRCS)  # 将当前目录子的文件保存在变量 EXTERNAL_SRCS_LIST中
list(APPEND DIR_SRCS ${EXTERNAL_SRCS})        # 将 OTHER_SRC_LIST 添加到SRC_LIST 中
add_library(native_lib_for_debug SHARED ${DIR_SRCS})

#add_library( # Sets the name of the library.
#             native_lib_for_debug

             # Sets the library as a shared library.
#             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
#             src/main/cpp/my_first_jni.h src/main/cpp/my_first_jni.cpp src/main/cpp/SignatureVerification.h  src/main/cpp/SignatureVerification.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because system libraries are included in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in the
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native_lib_for_debug

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib})