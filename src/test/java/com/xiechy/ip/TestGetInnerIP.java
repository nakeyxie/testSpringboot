package com.xiechy.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @ClassName TestGetInnerIP
 * @Description TODO
 * @Author xcy
 * @Date 2020/6/1 10:30
 */
public class TestGetInnerIP {
    //这个方法有局限性  对于本系统自身 只能获取内网IP 本地测试用
// 实际Linux系统  可改用下面那个方法，执行 curl 命令来获取
    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }


    //执行 curl 命令
     //执行 curl icanhazip.com 命令，可获取公网IP
    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        //内网
        System.out.println("IP为："+getIpAddress());
        //公网
        String[] cmds={"curl","icanhazip.com"};//必须分开写，不能有空格
        String localIP = execCurl(cmds).trim();
        System.out.println("公网IP："+localIP);
    }
}
