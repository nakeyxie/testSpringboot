package com.xiechy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestReadProperties {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String code = getCode();
		System.out.println(code);

	}
	//读取文件属性
	public static String getCode() throws FileNotFoundException{
		//获取文件路径
		String path =  TestReadProperties.class.getClassLoader().getResource("test/java/com/xiechy/properties/user.properties").getPath();
		Properties p;
		InputStream in = new BufferedInputStream(new FileInputStream(path));
        p = new Properties();
        try {
			p.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code= p.getProperty("usercode");
		return code+"路径为:"+path;
	}

}
