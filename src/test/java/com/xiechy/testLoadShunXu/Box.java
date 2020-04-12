package com.xiechy.testLoadShunXu;

/**
 * 可以看出类中各成员初始化的顺序是：
 * 父类的静态字段——>父类静态代码块——>子类静态字段——>子类静态代码块——>
 *
 * 父类成员变量（非静态字段）——>父类非静态代码块——>父类构造器——>子类成员变量——>子类非静态代码块——>子类构造器
 */
class A {
    private static int numA;
    private int numA2;
    
    static {
        System.out.println("A的静态字段 : " + numA);
        System.out.println("A的静态代码块");
    }
    
    {
        System.out.println("A的成员变量  : " + numA2);
        System.out.println("A的非静态代码块");
    }
 
    public A() {
        System.out.println("A的构造器");
    }
}
 
class B extends A {
    private static int numB;
    private int numB2;
 
    static {
        System.out.println("B的静态字段 : " + numB);
        System.out.println("B的静态代码块");
    }
    
    {
        System.out.println("B的成员变量 : " + numB2);
        System.out.println("B的非静态代码块");
    }
 
    public B() {
        System.out.println("B的构造器");
    }
}
 
public class Box {
    public static void main(String[] args) {
        A ab = new B();
        System.out.println("---");
        ab = new B();
    }
}
/*
版权声明：本文为CSDN博主「圣斗士Morty」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/u014745069/article/details/82655339*/
