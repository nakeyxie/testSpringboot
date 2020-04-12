package com.xiechy.test;

/**
 * 
 * @author Administrator
 * 多线程时如果多个线程调用同一个功能，最后才启动功能调用的线程
 * 当线程走到wait方法时，线程会挂起，让出对象锁，其他线程继续执行，当线程进到19行时，如果已有线程在里面了，会在外面等待，直到线程释放锁
 * 当线程执行notifyAll方法时，等待的线程全都唤醒，继续执行wait方法后面的代码！！！！
 * 
 */

public class TestTreadjiaohu2 extends Thread {
	ThreadSum2 sum;

	public TestTreadjiaohu2(ThreadSum2 sum) {
		this.sum = sum;
	}
	@Override
	public void run() {
		synchronized (sum) {
			try {
				System.out.println("等待对象sum完成计算。。。");
				// 当前线程ThreadInteractionTest等待
				sum.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("sum对象计算的总和是：" + sum.total);
		}
	}

	public static void main(String[] args) {
		ThreadSum2 sum = new ThreadSum2();

		// 启动三个线程，分别获取计算结果
		new TestTreadjiaohu2(sum).start();
		new TestTreadjiaohu2(sum).start();
		new TestTreadjiaohu2(sum).start();

		// 启动计算线程
		sum.start();

	}
	
	//运行结果：
	/*等待对象sum完成计算。。。
	等待对象sum完成计算。。。
	等待对象sum完成计算。。。
	唤醒全部
	sum对象计算的总和是：5050
	sum对象计算的总和是：5050
	sum对象计算的总和是：5050*/
}

class ThreadSum2 extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			// 通知所有在此对象上等待的线程
			notifyAll();
			System.out.println("唤醒全部");
		}
	}
}


