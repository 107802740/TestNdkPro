//
// Created by marson on 2017/1/4.
//
#include "stdafx.h"

#ifndef TESTNDKPRO_SIGNATUREVERIFICATION_H
#define TESTNDKPRO_SIGNATUREVERIFICATION_H

const char HexCode[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

class SignatureVerification {
public:
    SignatureVerification();
    ~SignatureVerification(void);

    bool verifySigntureBySha1(JNIEnv *env, jclass type, jobject context,const char *sign);
    bool verifySignture(JNIEnv *env, jclass type, jobject context,const char *sign);

private:
    bool isValid = false;
};


#endif //TESTNDKPRO_SIGNATUREVERIFICATION_H
