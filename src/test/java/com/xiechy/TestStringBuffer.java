package com.xiechy;

/**
 * @author xiechy
 * @create 2018-01-12
 * @Descrption
 **/
public class TestStringBuffer {
    public static void main(String[] args) {
        String buf = test1();
        System.out.println("buf:"+buf);
        System.out.println("=null:"+(buf==null));
        System.out.println("".equals(buf));//true
    }
    private static String test1() {
        StringBuffer  s = new StringBuffer();
        return  s.toString();
    }
    
}




    
        