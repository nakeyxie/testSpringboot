package com.xiechy.classLayout;

import org.openjdk.jol.info.ClassLayout;

/**
 * 打印对象布局
 */
public class testLayout {

    public static void main(String[] args) {

        Object o = new Object();
        o.hashCode();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        //上锁
        synchronized(o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
