package com.xiechy.coder;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.junit.Test;

/**
 * @ClassName TestHuToolJM
 * @Description 用huTool工具加密代码
 * @Author xcy
 * @Date 2021/4/27 13:45
 */
public class TestHuToolJM {

    /**
     *Hutool支持的对称加密算法枚举有：
     *
     * AES
     * ARCFOUR
     * Blowfish
     * DES
     * DESede
     * RC2
     * PBEWithMD5AndDES
     * PBEWithSHA1AndDESede
     * PBEWithSHA1AndRC2_40
     * 这些枚举全部在SymmetricAlgorithm中被列举
     *
     *
    */



    @Test
    public void aes(){
        //AES加密解密
        String content = "test中文";

        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

        //构建
        AES aes = SecureUtil.aes(key);

        //加密
        byte[] encrypt = aes.encrypt(content);
        //解密
        byte[] decrypt = aes.decrypt(encrypt);

         //加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        //解密为字符串
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println("加密:"+encryptHex);
        System.out.println("解密:"+decryptStr);
    }



   public void des(){
       //DES加密解密
       //DES的使用方式与AES基本一致

       String content = "test中文";

       //随机生成密钥
       byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

       //构建
       DES des = SecureUtil.des(key);

       //加密解密
       byte[] encrypt = des.encrypt(content);
       byte[] decrypt = des.decrypt(encrypt);

       //加密为16进制，解密为原字符串
       String encryptHex = des.encryptHex(content);
       String decryptStr = des.decryptStr(encryptHex);
   }
}
