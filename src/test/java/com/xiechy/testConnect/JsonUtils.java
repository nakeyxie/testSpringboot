package com.xiechy.testConnect;

import java.util.List;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonUtils {

	public static String toJSONString(Object object,boolean fiterNull,List<String> excludeProperties,
			SerializerFeature... features) {
		String str="";
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer= new JSONSerializer(out);
		SerializerFeature[] fts = features;
		int length =fts.length;
		for(int i=0;i<length;i++){
			SerializerFeature feature=fts[i];
			serializer.config(feature, true);
		}
		serializer.getPropertyFilters().add(new IgonrefieldPreFilter(fiterNull,excludeProperties));
		serializer.setDateFormat("yyyy-MM-dd HH:mm:sss");
		serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
		serializer.write(object);
		str=out.toString();
		out.close();
		return str;
	}
	
	public static String toJSONString(Object object) {
		return  toJSONString(object,true,null);
	}

}
