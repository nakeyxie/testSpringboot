package TestTcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) throws Exception {
		/*for(int i=0;i<5;i++){
			rquest();
		}*/
		//request2();
		request();
		
	}

	private static void request() throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 9999);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream  ps  = new PrintStream(os);
		
		
		System.out.println(br.readLine());
		ps.println("帮我把信息转给他，说早上好！");
		System.out.println(br.readLine());
		ps.println("走了，拜拜服务器");
		

		/*byte[] arr = new byte[1024];
		// 读取服务器发来的信息
		int len1 = is.read(arr);
		System.out.println(new String(arr,"GBK"));
		os.write("�ͻ��˷����ʺ�".getBytes());*/

		socket.close();
	}
	
	public static void request2() throws Exception{
		Socket socket = new Socket("127.0.0.1", 9999);
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		Scanner  sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintStream  ps  = new PrintStream(os);
		ps.println(sc.nextLine());
		System.out.println(br.readLine());
		socket.close();
		
	}

}
