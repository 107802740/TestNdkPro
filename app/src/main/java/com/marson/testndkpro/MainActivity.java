package com.marson.testndkpro;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.marson.testndkpro.utils.RSACoder;

public class MainActivity extends Activity {

    //RSA公钥
private String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmq72crbtK2CE/kpxW7Gy//FEIwwOnPVaejW7D"+
        "99Wfnz0IY9dbJJlKFEf29JTlUbDtSg+yF+sQ4Z6I+TDyHR7SXn9Cj97CK0veYrgGqf3J5Yw4NUmi"+
        "dri0ScTvP/YWNMRPOSagrIwjJ9Cr9WklgUddUBoiDr+0UQEiRW1alFlj+wIDAQAB";

//RSA私钥
    private String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKarvZytu0rYIT+SnFbsbL/8UQjD"+
            "A6c9Vp6NbsP31Z+fPQhj11skmUoUR/b0lOVRsO1KD7IX6xDhnoj5MPIdHtJef0KP3sIrS95iuAap"+
            "/cnljDg1SaJ2uLRJxO8/9hY0xE85JqCsjCMn0Kv1aSWBR11QGiIOv7RRASJFbVqUWWP7AgMBAAEC"+
            "gYBQqUsRmY7L8P9eSfD5rGARJeZ9zAtnk6ro/t+9XaL4JlOeTNt7k6HQFTKi1Ml+leN/Y1lnQmYT"+
            "/G0CMz853Vf9hXS3aBmcruy3Bq6rhNmygRufuxqVfZeEOJ3w8EmxD1/oqfYljL8c9XTuA8B/zLTy"+
            "cD843XjX0kh906SNigpXqQJBANgOrBq+avGe4N281Z8B/naSmiEQyU0tvGcUPPYJ0xRkwfVR3heK"+
            "mtMy9CpktBCm7sOIhtE0ue7/LRdooCxuXQcCQQDFe8J21EktQCwe0v6Vocu/9leBScDG943ZxzHp"+
            "XjHtAdnQo0tmoWvA1Hp8Qr/utjcfESx2kc3YDJAJRDM0m/htAkEAqdL2klrkAqGITKJWIxLVKexX"+
            "u+/O2pw9f6RXumjEgj4keqhr8oMe6S0e4IehRYmBGS6iEaTpFSN8FO9HH0VsVwJBAL/mVz2pY8J5"+
            "DWaWmZVFt/w9oSKdTJsLi+gHzNR9F/67QbGgPHDqgw7Kaou9QUzx+/ZQdehyHpjG/GBEyY1h0rEC"+
            "QFYGkLlUASO+D91/8LRMHkFfYLOPJB3AXsLkaLvMNdnCV3vkRDXTPTWXHhcrVt2dUla4SZw+SPjz1XSnRPc3dHA=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        try {
            boolean flag=true;
            String str ="中";
            if(flag){
                str= "中华人民共和国\nThe pulbic of China\n";
            }
            String signStr = RSACoder.encryptBASE64(RSACoder.encryptByPublicKey(str.getBytes(), publicKey));
            Log.d("Test",signStr);
            String afterStr = new String(RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(signStr), privateKey));

            String sign = RSACoder.sign(str.getBytes(), privateKey);
            boolean b = RSACoder.verify(str.getBytes(), publicKey, sign);
            tv.setText("私钥:" + privateKey + "\n公钥：" + publicKey + "\n原文:" + str + "密文：" + signStr + "\n解密：" + afterStr + "\n数字签名 ：" + sign + "\n检验 ：" + b);
            Log.e("Test", "私钥:" + privateKey);
            Log.e("Test", "公钥:" + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
