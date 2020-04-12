package com.xiechy.test;

public class testSingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*测试多线程情况下的单例模式*/
		//线程1
		
		  Thread  t1 = new Thread(new Runnable(){
			  @Override
			public void run() {
				  SingletonClass  singletonClass =null;				 
				  singletonClass=  SingletonClass.getInstance();
				  System.out.println("线程1的单例："+singletonClass.toString());
				  
				
			}
		  });
		  //线程2
		  Thread  t2 = new Thread(new Runnable(){
			  @Override
			public void run() {
				  SingletonClass  singletonClass1 =null;
				  singletonClass1=  SingletonClass.getInstance();
				  System.out.println("线程2的单例："+singletonClass1.toString());
				
			}
		  });

		  t1.start();
		  t2.start();
		 /* 执行结果：
		  开始睡觉5秒
		  线程1的单例：com.xiechy.test.SingletonClass@134bed0
		  睡觉结束
		  线程2的单例：com.xiechy.test.SingletonClass@13c1b02
		  */
		

	}

}
