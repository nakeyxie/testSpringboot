package com.xiechy.test;

public class TestTreadjiaohu {

	/**
	 * @param 测试线程交互
	 * 断点调试过程：
	 * new一个线程，线程点start()方法后，就出现2个线程
	 * main线程 和sum线程 从此刻起2个线程同时工作
	 * 当main线程走到wait方法时此线程挂起等待
	 * 当sum线程计算完毕后run方法结束，main线程才继续执行！
	 * 
	 */
	public static void main(String[] args) {
		 ThreadSum sum = new ThreadSum();
	        // 启动计算线程
	        sum.start();
	        // 线程TestTreadjiaohu拥有sum对象上的锁。
	        // 线程为了调用wait()或notify()方法，该线程TestTreadjiaohu必须是那个对象锁的拥有者
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

}

class ThreadSum extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 101; i++) {
				total += i;
			}
			// (完成计算了)唤醒在此对象监视器上等待的单个线程，在本例中线程TestTreadjiaohu被唤醒
			//唤醒在此对象锁上等待的单个线程。此方法只能由拥有该对象锁的线程来调用。

			notify();//唤醒的是调用此对象（线程）wait方法的线程
			System.out.println("已唤醒");
		}
	}
}
