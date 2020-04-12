package com.xiechy.test;
public class B64Demo {
    public static String getBASE64(String s) {  
        if (s == null)  
            return null;  
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());  
    }  
    // 将 BASE64 编码的字符串 s 进行解码   解密
    public static String getFromBASE64(String s) {  
        if (s == null)  
            return null;  
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
        try {  
            byte[] b = decoder.decodeBuffer(s);  
            return new String(b);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
    public static String mTOa(Object ming){
        return B64Demo.getBASE64(B64Demo.getBASE64(B64Demo.getBASE64((String)ming)));
    }
    public static String aTOm(String an){
        return B64Demo.getFromBASE64(B64Demo.getFromBASE64(B64Demo.getFromBASE64(an)));
    }
    public static void main(String[] args) {
        String a = mTOa("2016-11-25-单据保存".toString());
          System.out.println(a);//加密
          System.out.println(aTOm(a));//解密
    }
}