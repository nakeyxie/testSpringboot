package com.xiechy.test;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.setDaemon(true);
		t.start();//不需要等待执行完，直接执行下面语句-----执行此方法会创建一个新的线程去处理，这个线程创建的线程也为守护线程
		//t.run();//需要等等run完才执行下面的语句------执行此方法还是当前线程去执行，并没有创建新的线程，所以下面子线程并不是守护线程
		System.out.println("run完");
		
		System.out.println("Thread Test");
		
		/*开始睡眠
		开始睡眠
		睡眠结束
		MyThread running
		睡眠结束
		MyThread running
		run完
		Thread Test*/
		
		/********************************************************///2种方式的运行结果
		/*MyThread t = new MyThread();
		
		t.run();//需要等等run完才执行下面的语句
		System.out.println("run完");
		t.start();//不需要等待执行完，直接执行下面语句
		System.out.println("Thread Test");
		*/

		
		/*开始睡眠
		睡眠结束
		MyThread running
		Thread Test
		开始睡眠
		睡眠结束
		MyThread running
		*/

		
	}

}


class MyThread extends Thread{
	public void run(){
	try {
		System.out.println("开始睡眠");
		System.out.println("是否守护线程:"+this.isDaemon());
		Thread  a = new Thread(){
			public void run(){
				System.out.println("子线程是否守护线程"+this.isDaemon());
			}
		};
		a.start();
	Thread.currentThread().sleep(3000);//获取的是运行本行代码的线程
	System.out.println("睡眠结束");
	} catch (InterruptedException e) {
	}
	System.out.println("是否守护线程:"+this.isDaemon());
	System.out.println("MyThread running");
	}
}
