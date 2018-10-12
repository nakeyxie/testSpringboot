package com.xiechy.http;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

public class HttpUtils {
    private static Logger log = Logger.getLogger(HttpUtils.class);
    public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";
    public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";
    private static final String URL_PARAM_CONNECT_FLAG = "&";
    private static final String EMPTY = "";
    private static MultiThreadedHttpConnectionManager connectionManager = null;
    private static int connectionTimeOut = 10000;
    private static int socketTimeOut = 10000;
    private static int maxConnectionPerHost = 200;
    private static int maxTotalConnections = 2000;
    private static HttpClient client;

    public HttpUtils() {
    }

    public static Boolean existHttpPath(String httpPath) {
        URL httpurl = null;

        try {
            httpurl = new URL(httpPath);
            URLConnection e = httpurl.openConnection();
            e.getInputStream();
            return Boolean.valueOf(true);
        } catch (Exception var3) {
            return Boolean.valueOf(false);
        }
    }

    public static List<NameValuePair> GenerateParameters(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class c = obj.getClass();
        ArrayList parameters = new ArrayList();
        Field[] var3 = c.getDeclaredFields();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Field field = var3[var5];
            String name = field.getName();
            Method getFieldMethod = null;
            Method[] value = c.getDeclaredMethods();
            int nameValuePair = value.length;

            for(int var11 = 0; var11 < nameValuePair; ++var11) {
                Method method = value[var11];
                if(method.getName().equalsIgnoreCase("get" + name)) {
                    getFieldMethod = method;
                    break;
                }
            }

            Object var14 = getFieldMethod.invoke(obj,new Object[0]);
            if(var14 != null){
                if(var14 instanceof String){
                    if(!StringUtils.isEmpty(var14.toString())) {
                        NameValuePair var13 = new NameValuePair(name, var14.toString());
                        parameters.add(var13);
                    }
                }else{

                }
            }
        }

        return parameters;
    }

    public static String URLPost(String url, Map<String, String> params, String enc) {
        String response = "";
        PostMethod postMethod = null;

        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            setParameters(params, postMethod);
            response = executePost(response, postMethod);
        } catch (HttpException var10) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var10);
            var10.printStackTrace();
        } catch (Exception var11) {
            log.error("发生网络异常", var11);
            var11.printStackTrace();
        } finally {
            if(postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }

        }

        return response;
    }

    /**
     * 传输非字符串形式参数
     * @param url
     * @param params
     * @param enc
     * @return
     */
    public static String URLPost1(String url, Map<String, Object> params, String enc) {
        String response = "";
        PostMethod postMethod = null;
        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            setParameters1(params, postMethod);
            response = executePost(response, postMethod);
        } catch (HttpException var10) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var10);
            var10.printStackTrace();
        } catch (Exception var11) {
            log.error("发生网络异常", var11);
            var11.printStackTrace();
        } finally {
            if(postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }

        }

        return response;
    }


    public static String URLPostJSON(String url,String json, String enc){
        String response = "";
        PostMethod postMethod = null;

        try {
            postMethod = new PostMethod(url);
            RequestEntity se = new StringRequestEntity(json,"application/json",enc);
            postMethod.setRequestEntity(se);
            //使用系统提供的默认的恢复策略
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            //设置超时时间
            //postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,100);
            response = executePost(response, postMethod);
        } catch (HttpException var10) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var10);
            var10.printStackTrace();
        } catch (IOException var11) {
            log.error("发生网络异常", var11);
            var11.printStackTrace();
        } finally {
            if(postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }

        }

        return response;
    }

    public static String URLPost(String url, Object obj, String enc) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String response = "";
        PostMethod postMethod = null;

        try {
            postMethod = new PostMethod(url);
            postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            List e = GenerateParameters(obj);
            setParameters(e, postMethod);
            response = executePost(response, postMethod);
        } catch (HttpException var10) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var10);
            var10.printStackTrace();
        } catch (IOException var11) {
            log.error("发生网络异常", var11);
            var11.printStackTrace();
        } finally {
            if(postMethod != null) {
                postMethod.releaseConnection();
                postMethod = null;
            }

        }

        return response;
    }

    public static String executePost(String response, PostMethod postMethod) throws IOException, HttpException {
        int statusCode = client.executeMethod(postMethod);
        if(statusCode == 200) {
            response = postMethod.getResponseBodyAsString();
        } else {
            log.error("响应状态码 = " + postMethod.getStatusCode());
        }

        return response;
    }

    private static void setParameters(List<NameValuePair> data, PostMethod postMethod) {
        NameValuePair[] nameValuePairs = new NameValuePair[data.size()];
        postMethod.setRequestBody((NameValuePair[])data.toArray(nameValuePairs));
    }

    private static void setParameters(Map<String, String> params, PostMethod postMethod) {
        Set keySet = params.keySet();
        Iterator var3 = keySet.iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            String value = (String)params.get(key);
            postMethod.addParameter(key, value);
        }

    }

    /**
     * 设置任何类型的数据
     * @param params
     * @param postMethod
     */
    public static void setParameters1(Map<String,Object> params, PostMethod postMethod){
        Set keySet = params.keySet();
        Iterator var3 = keySet.iterator();
        HttpMethodParams p = new HttpMethodParams();
        while(var3.hasNext()) {
            String key = (String)var3.next();
            Object value = params.get(key);
            p.setParameter(key,value);
        }
        postMethod.setParams(p);
    }


    public static String URLGet(String url, Map<String, String> params, String enc) {
        String response = "";
        GetMethod getMethod = null;
        StringBuffer strtTotalURL = new StringBuffer("");
        if(strtTotalURL.indexOf("?") == -1) {
            strtTotalURL.append(url).append("?").append(getUrl(params, enc));
        } else {
            strtTotalURL.append(url).append("&").append(getUrl(params, enc));
        }

        log.debug("GET请求URL = \n" + strtTotalURL.toString());

        try {
            getMethod = new GetMethod(strtTotalURL.toString());
            getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
            int e = client.executeMethod(getMethod);
            if(e == 200) {
                response = getMethod.getResponseBodyAsString();
            } else {
                log.debug("响应状态码 = " + getMethod.getStatusCode());
            }
        } catch (HttpException var11) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var11);
            var11.printStackTrace();
        } catch (IOException var12) {
            log.error("发生网络异常", var12);
            var12.printStackTrace();
        } finally {
            if(getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }

        }

        return response;
    }

    public static boolean URLGetVideo(String url) {
        GetMethod getMethod = null;

        boolean var3;
        try {
            getMethod = new GetMethod(url);
            getMethod.setRequestHeader("Content-Type", "video/mpeg4");
            int e = client.executeMethod(getMethod);
            if(e == 200) {
                var3 = true;
                return var3;
            }

            log.debug("响应状态码 = " + getMethod.getStatusCode());
            var3 = false;
        } catch (HttpException var8) {
            log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", var8);
            var8.printStackTrace();
            return false;
        } catch (IOException var9) {
            log.error("发生网络异常", var9);
            var9.printStackTrace();
            return false;
        } finally {
            if(getMethod != null) {
                getMethod.releaseConnection();
                getMethod = null;
            }

        }

        return var3;
    }

    private static String getUrl(Map<String, String> map, String valueEnc) {
        if(null != map && map.keySet().size() != 0) {
            StringBuffer url = new StringBuffer();
            Set keys = map.keySet();
            Iterator strURL = keys.iterator();

            while(strURL.hasNext()) {
                String key = (String)strURL.next();
                if(map.containsKey(key)) {
                    String val = (String)map.get(key);
                    String str = val != null?val:"";

                    try {
                        str = URLEncoder.encode(str, valueEnc);
                    } catch (UnsupportedEncodingException var9) {
                        var9.printStackTrace();
                    }

                    url.append(key).append("=").append(str).append("&");
                }
            }

            String strURL1 = "";
            strURL1 = url.toString();
            if("&".equals("" + strURL1.charAt(strURL1.length() - 1))) {
                strURL1 = strURL1.substring(0, strURL1.length() - 1);
            }

            return strURL1;
        } else {
            return "";
        }
    }

    static {
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
        connectionManager.getParams().setSoTimeout(socketTimeOut);
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
        connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
        client = new HttpClient(connectionManager);
    }
}
