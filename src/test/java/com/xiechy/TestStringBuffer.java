package com.xiechy;

import org.junit.Test;

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

    @Test
    public void test(){
        StringBuffer buf = new StringBuffer();
        for (int i =0;i<9;i++){
            buf.append("45");
            buf.append(",");
        }
        String samples =buf.toString().substring(0,buf.length()-1);
        System.out.println(samples);
    }
    
}




    
        