package com.xiechy.coder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.Charset;

/**
 * @ClassName DesDemo
 * @Description des对称加密
 * @Author xcy
 * @Date 2021/4/29 8:37
 */
public class DesDemo {


    /**
     * @Description 加密
     * @Author xcy
     * @Date
     * @param strIn
     * @param sKey
     * @param charset
     * @return java.lang.String
    */
    private  static String encryptDES(String strIn, String sKey, String charset){
        byte[] buf = null;
        String rst = null;
        try{
            //需要加密的数组
            byte[] arrB = strIn.getBytes(charset);
            byte[] key = sKey.getBytes();
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKey = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            buf = cipher.doFinal(arrB);
            rst =byteArr2HexStr(buf);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rst;
    }




    /**
     * @Description 解密
     * @Author xcy
     * @Date
     * @param strIn
     * @param sKey
     * @param charset
     * @return java.lang.String
     */
    private static String decryptDES(String strIn,String sKey,String charset){
        byte[] buf = null;
        try{
            byte[] result = new byte[strIn.length() / 2];
            for (int i = 0; i < strIn.length() / 2; i++) {
                int high = Integer.parseInt(strIn.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(strIn.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }

            byte[] key = sKey.getBytes();
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKey = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
            buf = cipher.doFinal(result);
        }catch(Exception e){
            return null;
        }
        String rst = new String(buf, Charset.forName(charset));
        return rst;
    }

    /**
     * 将byte数组转换为表示16进制值的字符串， 如：byte[]{8,18}转换为：0813， 和public static byte[]
     * hexStr2ByteArr(String strIn) 互为可逆的转换过程
     * @param arrB  需要转换的byte数组
     * @return 转换后的字符串
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "testDes123";
        String encrypt = encryptDES(str, "LqIiX5mq", "UTF8");
        System.out.println("加密后:"+encrypt);
        String decrypt = decryptDES("db687ab554c3ca830f775f1c804f4e1d" , "LqIiX5mq", "UTF8");
        System.out.println("解密后:"+decrypt);
    }
}
