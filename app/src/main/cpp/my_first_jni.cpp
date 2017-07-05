//
// Created by marson on 2017/1/4.
//

#include "my_first_jni.h"
#include "SignatureVerification.h"

extern "C"
void
Java_com_marson_testndkpro_jni_TestJNi_initValid(JNIEnv *env, jclass type, jobject context) {
    SignatureVerification verification;
    is_valid=verification.verifySignture(env,type,context,app_signature);
    if(!is_valid){
        string str;
        str.substr(1,5);
    }
}
extern "C"
void
Java_com_marson_testndkpro_jni_TestJNi_initValidBySha1(JNIEnv *env, jclass type, jobject context) {
    SignatureVerification verification;
    is_valid=verification.verifySigntureBySha1(env,type,context,app_signature_sha1);
    if(!is_valid){
        string str;
        str.substr(1,5);
    }
}

extern "C"
jstring
Java_com_marson_testndkpro_jni_TestJNi_stringFromJNI(JNIEnv *env, jclass type) {
    std::string hello = "Hello from C++J";
    return env->NewStringUTF(hello.c_str());
}



