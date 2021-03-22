package com.xiechy.testConfig;

public class TestBean {

    public synchronized void say(){
        System.out.println("hello!");

         synchronized (TestBean.class) {
            Object o = new Object();
        }
    }


    static  {
        Object o = new Object();
        System.out.println(o);
    }
}
