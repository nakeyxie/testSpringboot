package com.xiechy.testGC;

/**
 * @Author xcy
 * @Date 2020/4/20 22:00
 * ————————————————
 *     版权声明：本文为CSDN博主「laixiaoxing」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 *     原文链接：https://blog.csdn.net/qq_20009015/article/details/88809890
 * @Description TODO
 */
public class TestGC {
    private static final int _1MB = 1024 * 1024;
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //出现一次minor GC
        allocation4 = new byte[4 * _1MB];

    }


    public static void main(String[] args) {
        testAllocation();
    }

}
