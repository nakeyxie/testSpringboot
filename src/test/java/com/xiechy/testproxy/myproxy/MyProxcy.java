package com.xiechy.testproxy.myproxy;

import java.lang.reflect.Proxy;

public class MyProxcy {

    public static Object getInstance() {
        return Proxy.newProxyInstance(MyProxcy.class.getClassLoader(), new Class[]{JieKou.class}, new MyInvocation());
    }
}
