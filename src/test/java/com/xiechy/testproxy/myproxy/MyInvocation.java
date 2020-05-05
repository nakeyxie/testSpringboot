package com.xiechy.testproxy.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现类去执行实现类的方法
 */
public class MyInvocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("proxy:"+proxy.toString());
        Impl impl = new Impl();
        return method.invoke(impl,args);
    }
}
