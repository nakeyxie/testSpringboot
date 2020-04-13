package com.xiechy.testzhuangshizhe;

public class TestMain {

	/**
	 * @param args
	 */
	/*测试装饰者模式*/
	public static void main(String[] args) {
	// 一层一层套着，可以在一个方法基础上增加逻辑，和静态代理本质一样
	// 但是他们所出的上下文环境和目的不同
	 IZhuang iz = new Zhuang3(
			 new Zhuang2(
					 new Zhuang1(//增加额外功能
							 new ZhuangYw()//真正的业务逻辑
							 )
					 )
			 );
	 iz.work();
	 System.out.println(iz);
	}

}
			/*
			这个是测试装饰者模式的第三个继承类
			记录日志！
			开始执行括号对象的work
			这个是测试装饰者模式的第二个继承类
			处理事务！
			开始执行括号对象的work
			这个是测试装饰者模式的第一个继承类
			性能记录
			开始执行括号对象的work
			处理业务逻辑!
			执行完毕!1
			执行完毕!2
			执行完毕!3
			testzhuangshizhe.Zhuang3@1888759
			*/