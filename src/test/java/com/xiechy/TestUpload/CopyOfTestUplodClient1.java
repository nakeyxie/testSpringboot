package com.xiechy.TestUpload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CopyOfTestUplodClient1 {
	public static void main(String[] args) throws Exception {
		File file = getFile();

		Socket socket = new Socket("127.0.0.1", 8888);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket
				.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		// 发送文件名
		ps.println(file.getName());

		// 接收结果，走到这步的时候，线程会挂起，直到服务端有ps.println()有数据写回，线程继续
		String result = br.readLine();
		if ("存在".equals(result)) {
			System.out.println("上传的文件已存在！");
			socket.close();
			return;
		}
		// 如果存在，定义fileInputStream读取文件，写到网络
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		OutputStreamWriter osw= new OutputStreamWriter(ps,"UTF-8");
		char[] arr = new char[8192];
		int len = 0;
		while ((len = isr.read(arr)) != -1) {
			osw.write(arr, 0, len);
		}
		System.out.println("写出的数据为" + String.valueOf(arr));
		fis.close();
		br.close();
		isr.close();
		osw.close();
		socket.close();

		/*
		 * FileInputStream fis = new FileInputStream(file); byte[] arr = new
		 * byte[8*1024]; int len=0; while((len=fis.read(arr))!=-1){
		 * ps.write(arr,0,len); } fis.close(); socket.close();
		 */

	}

	public static File getFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入文件路径！");

		while (true) {
			String line = sc.nextLine();
			File file = new File(line);
			if (!file.exists()) {
				System.out.println("文件不存在，重输！");
			} else if (file.isDirectory()) {
				System.out.println("是文件夹，重输");
			} else {
				return file;
			}
		}
	}

}
