package com.xiechy;

/**
 * @author xiechy
 * @create 2018-01-02
 * @Descrption
 **/
public class TestLoadOrad {
    public TestLoadOrad(){
        System.out.println("构造");
    }
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
       /* TestLoadOrad  t = new sun();
        TestLoadOrad  t2 = new sun();*/
        Son  son = new Son();
    }
}
class Son extends  TestLoadOrad {
    public Son(){
        System.out.println("son 构造");
    }
    {
        System.out.println("son 代码块");
    }
    static {
        System.out.println("son  静态代码块");
    }
}



    
        