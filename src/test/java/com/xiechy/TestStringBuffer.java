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

    @Test
    public void test2(){
        StringBuilder sb = new StringBuilder();
        switch (1){
            case 1:sb.append("hello");
            case 2:sb.append("b");
            case 3:sb.append("c");
            default:sb.append("9");
        }
        System.out.println(sb.toString());
    }


    @Test
    public void test3(){
        int i =1;
       System.out.println(i++ + ++i);
    }

    @Test
    public void test4(){
        String a ="hello";
        System.out.println(a.substring(1,3));
    }


    @Test
    public void testLove(){
        StringBuffer love = new StringBuffer();
        love.append("today");
        love.append(",");
        love.append("I ");
        love.append("am ");
        love.append("going ");
        love.append("to ");
        love.append("marry ");
        love.append("you ");
        love.append("and ");
        love.append("go ");
        love.append("home");
        love.append(".");
        love.append("I ");
        love.append("want ");
        love.append("to ");
        love.append("say ");
        love.append("that ");
        love.append("I ");
        love.append("love ");
        love.append("you ");
        love.append("all ");
        love.append("my ");
        love.append("life");
        love.append(".");
        System.out.println(love.toString());



    }
    
}




    
        