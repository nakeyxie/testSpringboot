package testConnect;

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
		String json =JsonUtils.toJSONString(inputParam);
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

}
