package com.xiechy.test;

public class TestIO {

	/**
	 * @param args
	 * IO流具有一个设计模式：装饰者模式（俄罗斯套娃）
	 */
	public static void main(String[] args) {
		/** 字节流
		 * fileInputStream（FIS）
		 * fileOutputstream（FOS）
		 * 
		 * 
		 * 处理流（以下都是处理流）
		 * 
		 * 缓冲流，减少文件访问次数，提升读写的速度
		 * BuferedInputStream(BIS)
		 * BuffredOutputStrem(BOS)
		 * 
		 * 字符转换流，字符转换的功能
		 * InputStreamReader （ISR）
		 * OutputStreamWriter (OSW)
		 * 
		 * 
		 * 这个要套在字符转换流上面，有个方法readLine,可以一次读取一行字符
		 * BufereReader （BR）
		 * 
		 * 这个套在字符输出流上面，将各种数据的字符串表示输出
		 * PrintWriter （PW）
		 * 
		 * 对象流，实现对象的序列化和反序列化（OIS/OOS）----把内存里面的对象序列化成字节用于存贮和运输
		 * ObjectInputStream
		 * ObjectOutputSteam 
		 * 
		 * 什么情况需要序列化：需要实现serializable接口（里面没方法，要实现这个接口的原因是：将来这个类的变更的时候，已经序列化好的对象应该如何处理?）
		 * 
		 * 
		 * transient 声明变量，说明这个变量不参与序列化
		 */

	}

}
