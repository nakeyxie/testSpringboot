package com.xiechy;

import java.util.Scanner;

import org.junit.Test;

/**
 * @Author: xcy
 * @Date: 2020/4/14 18:17
 * 功能描述: 输入一个整数，要求是多个整数之和,如15 是:1,2,3,4,5之和
 */
public class TestIntegersSum {

    public static void main(String[] args) {
        new TestIntegersSum().integerSum();
    }

    @SuppressWarnings("resource")
    @Test
    public void integerSum() {
        System.out.println("请输入一个整数:");
        Scanner scan = new Scanner(System.in);
        int scanNum = scan.nextInt();
        //判断输入的是否是负数或正数
        boolean minusFlag = false;
        if (scanNum < 0) {
            scanNum = -scanNum;
            minusFlag = true;
        }
        //是否存在连续整数相加
        boolean hasflag = false;
        //循环输入数字的一半
        for (int i = 1; i <= scanNum / 2; i++) {
            int num = i;
            for (int j = i + 1; j < scanNum; j++) {
            	//2个相连的数相加
                num += j;
                if (num > scanNum) {//如果大于跳出所有循环
                    break;
                } else if (num == scanNum) {//如果等于，证明存在连续的数
                    for (int k = i; k <= j; k++) {
                        if (!minusFlag) {
                            if (k < j) {
                                System.out.print(k + ",");
                            } else if (k == j) {
                                System.out.println(k);
                            }
                        } else {
                            if (k < j) {
                                System.out.print(-k + ",");
                            } else if (k == j) {
                                System.out.println(-k);
                            }
                        }

                    }
                    hasflag = true;
                    break;
                }

            }
        }

        if (!hasflag) {
            System.out.println("none");
        }
    }
}