package com.xiechy.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJSON {
	
    public static void main(String[] args) {
		/*String json="{\"UPDATE\":{\"DEPTCODE\":\"test02\",\"DEPTNAME\":\"test02\",\"ORGCODE\":\"04\",\"FATHERDEPT\":\"99901\"},\"DELS\":[{FATHERDEPT:'99902'},{\"FATHERDEPT\":\"99901\"},{\"FATHERDEPT\":\" \"}]}";
		doForJson(json);*/
		String delJson = "{UPDATE:[{DEPTCODE:'0220110',DEPTNAME:'测试接口',FATHERDEPT:'',CANCELED:'N',CREATEDATE:'2012-12-01',CANCELDATE:'2012-12-01',DEPTATTR:'2',HRCANCELED:'N',INNERCODE:'1Z02',DEPTCANCELDATE:'2012-12-01',ORGCODE:'01'},"
			+ "{DEPTCODE:'0220104',DEPTNAME:'测试更新名称接口',FATHERDEPT:'02020',CANCELED:'N',CREATEDATE:'2012-12-01',CANCELDATE:'2012-12-01',DEPTATTR:'2',HRCANCELED:'N',INNERCODE:'1Z02',DEPTCANCELDATE:'2012-12-01',ORGCODE:'01'}],"
			+ "DELS:[{DEPTCODE:'0220108',ORGCODE:'01'},{DEPTCODE:'0220199',ORGCODE:'01'}]}";
		doForJson(delJson);
	}

	private static void doForJson(String json) {
		JSONObject  jobj = (JSONObject) JSON.parse(json);
		JSONArray deptjson = jobj.getJSONArray("UPDATE");
		/*String code = deptjson.getString("DEPTCODE");
		String name = deptjson.getString("DEPTNAME");*/
		//System.out.println("code:"+code+"  name:"+name);
		JSONArray  arrJson = jobj.getJSONArray("DELS");
		for(Object obj : arrJson){
			JSONObject  jsonobject = (JSONObject) obj;
			if(!jsonobject.isEmpty()){
				String fatherDept = jsonobject.getString("FATHERDEPT");
				System.out.println(isEmpty(fatherDept));
				System.out.println("fatherDEpt:"+fatherDept);
			}
		}
		for(Object obj: deptjson){
			JSONObject jsonobj = (JSONObject) obj;
			System.out.println("code="+jsonobj.getString("DEPTCODE"));
		}
		
		JSONObject testobj = new JSONObject();
		testobj.put("test", new String("123"));
		testobj.put("testarr", new int[]{1,2,3});
		testobj.put("obj", arrJson);
		System.out.println(testobj.toJSONString());
		System.out.println(testobj);
		System.out.println("测试空的json数组");
		JSONArray arr1 = new JSONArray();
		JSONArray arr2 = new JSONArray();
		JSONObject testjson1= new JSONObject();
		JSONObject unit = new JSONObject();
		unit.put("dajdsa", "adssda");
		arr2.add(unit);
		testjson1.put("UPDATE", arr1);
		testjson1.put("DELS", arr2);
		
		JSONArray arr3 = testjson1.getJSONArray("UPDATE");
		if(arr3.isEmpty()){
			System.out.println("arr1为空");
		}
		if(!testjson1.getJSONArray("DELS").isEmpty()){
			System.out.println("arr2不为空");
		}
		
	}
	
	 public static boolean isEmpty(String str)
	    {
	        return str == null || str.length() == 0;
	    }

}
