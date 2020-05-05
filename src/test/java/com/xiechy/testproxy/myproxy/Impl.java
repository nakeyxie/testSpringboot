package com.xiechy.testproxy.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Impl implements JieKou {


    @Override
    public void doSomeThing() {
        System.out.println("hello,dongTaiDaiLi");
    }
}
