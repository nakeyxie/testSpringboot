package com.xiechy.TestUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CopyOfTestUplodServer1 {

	/**
	 * @param args
	 * @throws Exception
	 * 读取字符，解决乱码问题
	 * 乱码原因：上传的文件打开是乱码，是因为工作环境默认的编码集是：UTF-8
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器启动");
		while (true) {
			final Socket socket = server.accept();

			new Thread() {
				public void run() {
					// 读取文件名
					try {
						// alt+shift+L抽取变量出来 alt+shift+m 抽取方法出来
						InputStream is = socket.getInputStream();
						
						InputStreamReader isr = new InputStreamReader(is, "UTF-8");// 设置读入字符的编码格式
						
						BufferedReader br = new BufferedReader(
								new InputStreamReader(is));
						PrintStream ps = new PrintStream(socket
								.getOutputStream());
						String fileName = br.readLine();
						File dir = new File("Upload");
						// 此方法是，文件夹存在就不创建了，如果不存在就创建！
						dir.mkdir();
						File file = new File(dir, fileName);
						// 判断文件是否存在，将结果发回客户端
						if (file.exists()) {
							ps.println("存在");
							socket.close();
							return;

						} else {// 要么存在，要么不存在，不能用 else if(file.isDirtory())判断
							ps.println("不存在");
						}
						// 从网络读取数据，存储到本地
						
						OutputStreamWriter pw = new OutputStreamWriter(new FileOutputStream(file),
								"UTF-8");// 设置编码格式
						char[] arr = new char[8*1024];
						int len;
						// 用字节流读取数据合适
						// 发送不存在之后，客户端的线程开始写入数据，假如还没写入完毕，下面的程序执行不下去，线程会挂起
						while ((len = isr.read(arr)) != -1) {// is点读到arr里去
							//fos.write(arr, 0, len);// fos从字节数组里写到文件中
							System.out.println("读取到的数据为："+String.valueOf(arr));
							 pw.write(arr, 0, len);//pw从字符数组中写到文件
						}
						System.out.println("写出为字符为："+String.valueOf(arr));
						pw.close();//关流
						ps.close();
						socket.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();

		}

	}

}
