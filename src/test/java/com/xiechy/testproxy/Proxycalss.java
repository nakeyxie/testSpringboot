package com.xiechy.testproxy;

public class Proxycalss implements Queryshuju {
	/*实际上是委托类在干活！！！！！*/
	private Weituoclass  weiTuo=null;
	public  Proxycalss(){
		this.weiTuo=new Weituoclass();
		
	}


	public void Query1() {
		System.out.println("代理类开始委托查询1");
		weiTuo.Query1();

	}


	public void Query2() {
		System.out.println("代理类开始委托查询2");
		weiTuo.Query2();
	}

}
