package com.xiechy.TestTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	
	public  static String msg="";
	public static void main(String[] args) throws Exception {
		// newServer();
		ServerSocket server = new ServerSocket(9999);
		System.out.println("开启服务器！");
		//多线程服务器
		while (true) {
			final Socket socket = server.accept();
			new Thread() {
				public void run() {
				
						try {
							BufferedReader br = new BufferedReader(
									new InputStreamReader(socket
											.getInputStream()));
							PrintStream ps = new PrintStream(socket
									.getOutputStream());
							ps.println("已连接到服务器");
							String line = new StringBuffer(br.readLine()).reverse().toString();
							if(line.contains("帮")){
								msg=line;//需要转发的消息存在内存中
							}
							if(line.contains("B")){
								ps.println("转信息给客户端B:"+msg);//实现转发信息
							}
							ps.println("欢迎访问服务器，您输入的字符串反转为"+line);
							System.out.println(br.readLine());
							ps.println("再见客户端！");
							System.out.println(br.readLine());
							socket.close();
						} catch (Exception e) {
							// TODO: handle exception
						}
					
				}
			}.start();
		}

	}

	private static void newServer() throws IOException,
			UnsupportedEncodingException {
		// 创建服务器socket
		ServerSocket server = new ServerSocket(9999);
		// 接收客户端的请求
		Socket socket = server.accept();

		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		os.write(new String("服务器发来贺电").getBytes());

		byte[] arr = new byte[1024];
		// 读取客户端发来的信息
		int len1 = is.read(arr);
		System.out.println(new String(arr, "GBK"));

		server.close();
		socket.close();
	}

}
