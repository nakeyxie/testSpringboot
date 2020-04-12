package com.xiechy.test;

public interface TestInterface {
    abstract void a();
    void b();
    public  void c();
    //不能有static方法
    //可以有static变量
    public static int i =1;
    
    int dd();
    double dde();
}
