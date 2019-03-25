package com.xiechy.lock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xiechy
 * @create 2018-11-26
 * @Descrption 对锁的测试类
 **/
public class TestLock {

    private static  AtomicInteger count = new AtomicInteger(0);

    /**
     * 需要操作的变量
     */
    private static int NUM =1;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int result = add(1);
                System.out.println("t1----result:" + result);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int result = add(2);
                System.out.println("t2----result:" + result);
            }
        };
        t1.start();
        t2.start();
    }

    //目前测试方法对多线程不怎么支持，没有反应，所以改成上面的main方法测试
    @Test
    public void testBinFa() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int result = add(1);
                System.out.println("t1----result:" + result);
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                int result = add(2);
                System.out.println("t2----result:" + result);
            }
        };
        t1.start();
        t2.start();

    }

    private static int add(int threadCode) {
        while (true) {
            int v1 = NUM;
            int newNum = v1 + 1;
            int oldValue = count.get();
            //模拟并发场景 start
            if(1 == threadCode){
                try {
                    System.out.println("t1 sleep!");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
            //模拟并发场景 end
            System.out.println("threadCode:"+threadCode+",compareAndSet,oldValue:"+oldValue+",newNum:"+newNum);
            // compareAndSet 比较旧值是否改变，如果改变则返回false,如果没变返回true --当成原子操作
            if (count.compareAndSet(oldValue, oldValue+1)) {
                   NUM = newNum;
                return NUM;
            }
        }

    }

    public int update(int value) {
        //多线程进入
        while (true) {
            int oldValue = count.get();
            if (count.compareAndSet(oldValue, oldValue + 1)) {
                //执行更新操作,执行的操作必须时间很短，否则没什么用
                return value + 1;
            }
        }

    }


}




    
        