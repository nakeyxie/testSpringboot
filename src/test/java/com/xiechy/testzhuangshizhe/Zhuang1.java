package com.xiechy.testzhuangshizhe;

public class Zhuang1 implements IZhuang {
	//装饰者模式的特点在这一块：
	IZhuang iz ;
	public Zhuang1(IZhuang i){
		this.iz = i;
	}

	@Override
	public void work() {
		
	  System.out.println("这个是测试装饰者模式的第一个继承类");
	  System.out.println("性能记录");
	  System.out.println("开始执行括号对象的work");
	   iz.work();
	   System.out.println("执行完毕!1");

	}

}
