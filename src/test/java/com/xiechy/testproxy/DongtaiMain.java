package com.xiechy.testproxy;

import java.lang.reflect.InvocationHandler;

public class DongtaiMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*动态代理类*/
		InvocationHandler  dongtaiproxy = new DongtaiProxy();
		/*动态代理对象绑定接口实现类后，得到一个代理类（这个代理类也是实现动态书的接口的！）*/
		Dongtaibook  dongtaibookproxy = (Dongtaibook) ((DongtaiProxy) dongtaiproxy).bind(new Dongtaibookimpl());
		System.out.println(dongtaibookproxy.toString());
		System.out.println(dongtaibookproxy.getClass());
		/*代理对象处理(执行时完全不知道是接口实现类的方法)*/
		dongtaibookproxy.addBook();
         /*实现代理，可以在不改变原来代码的情况下，增加一些逻辑*/
	}

}
