package com.xiechy.thread;

public class HowToCreateThread {

    static class MyThread extends  Thread{

        @Override
        public void run() {
            System.out.println();
        }
    }

    static class MyRun implements Runnable{
        @Override
        public void run() {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("hello  lamda");
        }).start();
    }

    //启动线程的3钟方式
    //继承Tread   实现Runnable    线程池  Executor.new thread  通过线程池也可以启一个新的线程

}
