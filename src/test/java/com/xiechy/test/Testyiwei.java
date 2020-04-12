package com.xiechy.test;


import org.apache.log4j.Logger;

import sun.rmi.runtime.Log;
import sun.security.util.Debug;

public class Testyiwei {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//右移2位，再左移2位
		int i = 13>>2<<2;
		int j = 13/4*4;
		System.out.println(i);
		System.out.println(j);
		
		//测试前缀递增和后缀递增
		int k = 0;
		System.out.println("后缀递增：");
		System.out.println(k++);
		System.out.println(k);
		System.out.println("前缀递增：");
		System.out.println(++k);
		System.out.println(k);
		Debug.println("test", "test1");//system.err.println();
		
		
		//模拟使用Log4j记录不同级别的日志，
		//什么场景下应该记录什么级别的日志，
		//不同的企业有不同的规范，课上没法规范标准，
		//大家只要学会使用Log4j即可，至于什么场景
		//记录什么级别的日志，到企业中看规范
		
		//创建日志记录器
		Logger logger = 
			Logger.getLogger(Testyiwei.class);
		//记录日志
		logger.debug("aaa");//记录debug级别的日志
		logger.info("bbb");//记录info级别的日志
		logger.warn("ccc");//记录warn级别的日志
		logger.error("ddd");//记录error级别的日志
		logger.fatal("eee");//记录fatal级别的日志
	}

}
