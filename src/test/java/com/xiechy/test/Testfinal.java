package com.xiechy.test;


public class Testfinal extends Thread{
	protected int countDown=10;
	private static int count=0; //同一个线程里面，会改变count的值
	private  final int id=count++;//不定义成final的，当第二个对象new的时候id会变
	public String status(){
		return "#"+id+"("+(countDown>0?countDown:"发射")+"),";
	}
	public static void main(String[] args){
		Testfinal  f=new Testfinal();
		System.out.println("count:"+Testfinal.count);
		f.run();
		Testfinal  f1=new Testfinal();
		System.out.println("count:"+Testfinal.count);
		f1.run();	
		Testfinal  f2=new Testfinal();
		System.out.println("count:"+Testfinal.count);
		f2.run();	
		Testfinal  f3=new Testfinal();
		System.out.println("count:"+Testfinal.count);
		f3.run();	
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(countDown-->0){
			System.out.println(status());
            if(countDown==5){
    			Thread.yield();	//让出时间片，让其他线程执行
            }

		}
		
	}

	
	
	
	
}