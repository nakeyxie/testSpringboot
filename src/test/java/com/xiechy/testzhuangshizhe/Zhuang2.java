package com.xiechy.testzhuangshizhe;

public class Zhuang2 implements IZhuang {
	IZhuang iz;
	
	public Zhuang2(IZhuang i){
		this.iz=i;
	}
	

	@Override
	public void work() {
		 System.out.println("这个是测试装饰者模式的第二个继承类");
		 System.out.println("处理事务！");
		  System.out.println("开始执行括号对象的work");
		   iz.work();
		   System.out.println("执行完毕!2");
	}

}
