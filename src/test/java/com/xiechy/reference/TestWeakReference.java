package com.xiechy.reference;

import com.xiechy.code.User;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class TestWeakReference {

    public static void main(String[] args) {
        WeakReference<User> u = new WeakReference<User>(new User());

        System.out.println(u.get());
        System.gc();//一旦发生GC，弱引用就会被回收
        System.out.println(u.get());

        ThreadLocal<User> t1 = new ThreadLocal<>();
        t1.set(new User());
        //对象没有用了，必须remove ，否则，对象没有被回收
        t1.remove();
    }
}
