package com.xiechy.testConnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import sun.misc.BASE64Encoder;

/**
 * 用HTTPClient方式连接服务器
 * @author xiechengy
 *
 */
public class HttpConnect {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String url="http://localhost:8080/test";
		Map<String, Object> inputParam= new HashMap<String, Object>();
		inputParam.put("param1", "test1");
		inputParam.put("name", "xcy");
		inputParam.put("password", "123");
		String json = JsonUtils.toJSONString(inputParam);
		System.out.println(json);
		String addr="/do/epas/getPolicy";
        connect(url,json,addr);
	}

	@SuppressWarnings("restriction")
	private static void connect(String url, String json, String addr) throws Exception {
		HttpClient client = new HttpClient();//创建客户端
		PostMethod post = new PostMethod(url+addr);
		post.setRequestBody(json);
		post.addRequestHeader("Content-Type", "application/json:charSet-UTF-8");
		String userid="test";
		String password="123";
		String loginInfo=userid+":"+password;
		loginInfo=new BASE64Encoder().encode(loginInfo.getBytes("iso-8859-1"));
		post.addRequestHeader("Authorization", "Basic"+loginInfo);
		//
		client.executeMethod(post);
		
		String result=post.getResponseBodyAsString();
		System.out.println("qing qiu jie guo:"+result);
		post.releaseConnection();
	}

	private String invoke(String json,String URL) throws Exception {
		StringBuilder sb = new StringBuilder();
		try {
			java.net.URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setReadTimeout(120000);
			connection.setConnectTimeout(120000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(true);
			connection.setUseCaches(false);
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            connection.setRequestProperty("accept", "application/json");
			connection.setRequestProperty("appID", "5BE5EC70465B4F6AAEA7556AA933CAF2");//TODO
//            connection.setRequestProperty("authorization", YthConst.CONFIG_PARAM.authorization);

			byte[] writebytes = json.getBytes();
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(json.getBytes("UTF-8"));
			outputStream.flush();
			outputStream.close();

			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"GBK"));
				String temp;
				while ((temp = reader.readLine()) != null) {
					sb.append(temp);
				}
				reader.close();
			}else{
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream(),"GBK"));
				String temp;
				while ((temp = reader.readLine()) != null) {
					sb.append(temp);
				}
				reader.close();
				throw new Exception(sb.toString());
			}

			connection.disconnect();
		} catch (Exception e) {
			throw e;
		}
		return sb.toString();
	}

}
