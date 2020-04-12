package com.xiechy.test;

import java.io.IOException;
import java.util.Arrays;

import com.xiechy.dealbill.DealbillHVO;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class testForexample {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		StringBuffer  testBuf= new StringBuffer();
		Integer testInt=new Integer(5);
		DealbillHVO tesVO = new DealbillHVO();
		tesVO.setApplyid("test");
		tesVO.setDr(0);
		tesVO.setPk_corp("0001");
		testBuf.append("外面sql");
        testMoth(testBuf,testInt,tesVO);
        System.out.println(testBuf);//测试结果显示，StringBuffer可变长对象，其他方法调用这个对象就算不返回，也改变对象的值
        System.out.println(testInt);//结果显示int的值没变，因为int分配出来就占有引用了，值变了，引用的地址也会变
        System.out.println(tesVO.getApplyid());
        System.out.println(tesVO.getDr());
        System.out.println(tesVO.getPk_corp());
        System.out.println(tesVO.getReserve1());
        
        BASE64Encoder base64Encoder= new BASE64Encoder();
        String encode=base64Encoder.encode("测试".getBytes());
        System.out.println("加密："+encode);
        //解密字节
        byte[] decode=new BASE64Decoder().decodeBuffer(encode);
        /*乱码*/
        System.out.println("解密："+new String(decode,"iso8859-1"));
        //解密的字节和从字符获取的字节对比
        if(Arrays.equals("test".getBytes(), decode)){
        	System.out.println("一样");
        	//
        	
        	String string= new String();
        }
       /* int branks=5;
        for(int j=0;j<=10;j++){
        	if(j==branks){
        		throw new IllegalArgumentException();
        	}
        }*/
        int arr=Integer.MAX_VALUE;
        System.out.println((arr+1));
	}
	private static void testMoth(StringBuffer testBuf,Integer testInt,DealbillHVO tesVO) {
		testBuf.append("+里面sql");
		testInt+=5;
		tesVO.setPk_corp("0002");
		tesVO.setReserve1("test");
	}

}
