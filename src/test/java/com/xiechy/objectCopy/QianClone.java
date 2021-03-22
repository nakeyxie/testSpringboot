package com.xiechy.objectCopy;

import com.xiechy.code.User;

/**
 *  浅克隆，浅拷贝
 */
public class QianClone {

    public static void main(String[] args) {
        User u = new User();
        u.setId(1);
        u.setName("主线程");
        testCopy(u);
        System.out.println("主线程U:"+u.toString());
    }

    private static void testCopy(User u) {
        User u1 = u;//浅拷贝方式，只是让u1指向了u对象，u1更改其实是u对象更改
        u1.setId(2);
        u1.setName("方法里");
        System.out.println("U:"+u.toString());
        System.out.println("U1:"+u1.toString());
    }

}
