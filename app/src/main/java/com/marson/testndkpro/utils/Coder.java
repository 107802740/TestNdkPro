package com.marson.testndkpro.utils;

import android.util.Base64;


/**
 * @author wangxinyou.jason
 */
public class Coder {

    /**
     * Base64解码
     *
     * @param key
     * @return
     */
    public static byte[] decryptBASE64(String key) {
        return Base64.decode(key, Base64.DEFAULT);
    }

    /**
     * Base64编码
     *
     * @param sign
     * @return
     */
    public static String encryptBASE64(byte[] sign) {
        return Base64.encodeToString(sign, Base64.DEFAULT);
    }
}
