package com.xiechy.coder;


import cn.hutool.crypto.symmetric.DES;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @ClassName TestDes
 * @Description TODO
 * @Author xcy
 * @Date 2021/4/27 10:47
 */
public class TestDes {

    @Test
    public void testDes(){
        // 待加密内容
        String str = "cryptology";
        // 密码，长度要是8的倍数
        String password = "95880288";
        DES des = new DES();
        byte[] result = des.encrypt(str, password);
        System.out.println("加密后：" + new String(result));
        // 直接将如上内容解密
        try {
           // byte[] decryResult = DES.decrypt(result, password);
            byte[] decryResult = null;
            System.out.println("解密后：" + new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }





}
