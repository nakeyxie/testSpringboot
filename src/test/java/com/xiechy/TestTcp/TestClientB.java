package com.xiechy.TestTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClientB {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 9999);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream  ps  = new PrintStream(os);
		
		
		System.out.println(br.readLine());
		ps.println("我是客户端B");
		System.out.println("A的信息为:"+br.readLine());
		ps.println("B：走了");
		

		/*byte[] arr = new byte[1024];
		// 读取服务器发来的信息
		int len1 = is.read(arr);
		System.out.println(new String(arr,"GBK"));
		os.write("�ͻ��˷����ʺ�".getBytes());*/

		socket.close();
		
		
		
		
		
		
	}

}
