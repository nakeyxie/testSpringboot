package com.xiechy.coder;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import org.junit.Test;
import sun.security.provider.SHA;

import java.util.HashMap;

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


    @Test
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

   /**
    * @Description 对参数进行单向序列加密，不可逆，也叫加签
    * @Author xcy
    * @Date  2021/4/27 14:33
    * @param
    * @return void
   */
   @Test
   public void testSHA1(){
       SecureUtil.signParamsSha1(new HashMap<>());
   }

   public void testMD5(){
       SecureUtil.signParamsMd5(new HashMap<>());
   }

   /*1、MD5（Message Digest Algorithm 5）：是RSA数据安全公司开发的一种单向散列算法，非可逆，相同的明文产生相同的密文。
            2、SHA（Secure Hash Algorithm）：可以对任意长度的数据运算生成一个160位的数值；
    SHA-1与MD5的比较
    因为二者均由MD4导出，SHA-1和MD5彼此很相似。相应的，他们的强度和其他特性也是相似，但还有以下几点不同：
            1、对强行供给的安全性：最显著和最重要的区别是SHA-1摘要比MD5摘要长32 位。使用强行技术，产生任何一个报文使其摘要等于给定报摘要的难度对MD5是2128数量级的操作，而对SHA-1则是2160数量级的操作。这样，SHA-1对强行攻击有更大的强度。
            2、对密码分析的安全性：由于MD5的设计，易受密码分析的攻击，SHA-1显得不易受这样的攻击。
            3、速度：在相同的硬件上，SHA-1的运行速度比MD5慢。
            1、特征：雪崩效应、定长输出和不可逆。
            2、作用是：确保数据的完整性。
            3、加密算法：md5（标准密钥长度128位）、sha1（标准密钥长度160位）、md4、CRC-32
            4、加密工具：md5sum、sha1sum、openssl dgst。
            5、计算某个文件的hash值，例如：md5sum/shalsum FileName,openssl dgst –md5/-sha*/
}
