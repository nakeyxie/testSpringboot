package com.xiechy.testproxy.myproxy;

/**
 * 理解动态代理
 * 2020-5-1
 */
public class DongtaiDaiLiMain {

    public static void main(String[] args) {
        JieKou j = (JieKou) MyProxcy.getInstance();
        j.doSomeThing();
    }
}
