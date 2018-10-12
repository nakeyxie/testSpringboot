package com.xiechy;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @author xiechy
 * @create 2018-03-08
 * @Descrption String test = "  TCP    0.0.0.0:1099           0.0.0.0:0              LISTENING       183652\n" +
 * "  TCP    127.0.0.1:1099         127.0.0.1:58540        ESTABLISHED     183652\n" +
 * "  TCP    127.0.0.1:58535        127.0.0.1:1099         TIME_WAIT       0\n" +
 * "  TCP    127.0.0.1:58540        127.0.0.1:1099         ESTABLISHED     6724\n" +
 * "  TCP    [::]:1099              [::]:0                 LISTENING       183652";
 **/
public class TestOperatorCmd {
    public static void main(String[] args) {
        String order = "netstat -ano|findstr \"1099\"";
        String order1 = "ipconfig -all";
        //打开计算器
        String order2 ="calc";

        String order3 = "netstat -a";
        String order4="cmd /k ipconfig";
        String gbkOder = null;
        try {
            gbkOder = new String(order.getBytes(), "GBK");
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (gbkOder==null){
            System.out.println("转换异常！");
            return;
        }
        String outPut = callCmd(gbkOder);
        System.out.println("out:" + outPut);
        if (StringUtils.isEmpty(outPut)) {
            System.out.println("无输出结果！");
            return;
        }
        String result = killPid(outPut);
        System.out.println("处理结束：" + result);
    }

    private static String killPid(String outPut) {
        String pid = null;
        String[] outPutArr = outPut.split("\n");
        if (outPutArr != null) {
            for (int i = 0; i < outPutArr.length; i++) {
                String noSpaceStr = outPutArr[i].replaceAll("\\s*", "");
                if (noSpaceStr != null && noSpaceStr.contains("LISTENING")) {
                    //获取LISTENING后面的pid
                    int start = noSpaceStr.indexOf("G", -1);
                    pid = noSpaceStr.substring(start + 1);
                    break;
                }

            }

        }
        if (pid != null) {
            String killOrder = "taskkill /pid " + pid + " /f";
            String killOutPut = callCmd(killOrder);
            return killOutPut;
        } else {
            System.out.println("未找到pid！");
        }
        return null;
    }

    public static String callCmd(String order) {
        String line = null;
        StringBuilder sb = new StringBuilder();
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(order);
            String nomalMsg = readFile(process.getInputStream(), sb);
            if (StringUtils.isEmpty(nomalMsg)) {
                sb.append("错误提示：\n");
                return readFile(process.getErrorStream(), sb);
            } else {
                return nomalMsg;
            }
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static String readFile(InputStream in, StringBuilder sb) {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(in, "GBK"));
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return sb.toString();
    }


    @Test
    public void testRead() {
        try {
            //E:\testSpringboot\target\test-classes\abc.txt
            File file = new File(this.getClass().getResource("/").getPath() + "abc.txt");
            StringBuilder buffer = new StringBuilder();
            System.out.println(readFile(new FileInputStream(file), buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




    
        