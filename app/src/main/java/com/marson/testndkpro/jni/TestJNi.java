package com.marson.testndkpro.jni;

import android.content.Context;

/**
 * Created by marson on 2017/1/4.
 */

public class TestJNi {
    // Used to load the 'my_first_jni' library on application startup.
    static {
        System.loadLibrary("native_lib_for_debug");
    }
    /**
     * A native method that is implemented by the 'my_first_jni' native library,
     * which is packaged with this application.
     */
    public static native String stringFromJNI();
    public static native void initValid(Context context);
    public static native void initValidBySha1(Context context);
}
