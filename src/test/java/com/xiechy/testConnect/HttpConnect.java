package com.xiechy.testConnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.xiechy.http.HttpUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import org.junit.Test;
import sun.misc.BASE64Encoder;

/**
 * 用HTTPClient方式连接服务器
 *
 *
 * String msg = URLEncoder.encode(obj.getMsg(), "UTF-8");
 * 		String sendurl = MessageFormat.format(getBaseUrl("url"), obj.getMobile(), msg);
 * Administrator 18:20:27
 * name = URLEncoder.encode(name,"UTF-8");
 * url+name
 * Administrator 18:24:11
 * String url = "http://open.api.tianyancha.com/services/v4/open/match?name="+ URLEncoder.encode(name, "UTF-8")+"&keyword="+code;
 *
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

	@Test
	public void testReTest(){
		try {
			String url ="http://localhost:8888/bossqc/qcException/reTest";
			Map<String,String> paramMap = new HashMap<String,String>();
			//List<Long> ids = Arrays.asList(1L,2L,3L);
			paramMap.put("ids","[1,2,3]");
			paramMap.put("handDesc","testHandDesc");
			String response = HttpUtils.URLPost(url,paramMap,"UTF-8");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testReTestJSON(){
		try {
			String url ="http://localhost:8888/bossqc/qcException/reTest";
			JSONObject json = new JSONObject();
			//后台参数是什么类型的就设置成什么类型,然后json转换
			//后台对应字段为  ：private List<Long> ids;
			json.put("ids", Arrays.asList(1,2,3));
			json.put("handDesc","testHandDesc");
			String jsonStr = json.toJSONString();
			//如果请求是以JSON串的形式发送到后台，后端参数接收需要加requestBody
			String response = HttpUtils.URLPostJSON(url, jsonStr,"UTF-8");
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Test
	public void testFinishTest(){
		String url ="http://localhost:8888/bossqc/qcException/finishTest/3,4";
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("ids","1,2");
		String response = HttpUtils.URLPost(url,paramMap,"UTF-8");
		System.out.println(response);
	}

}
