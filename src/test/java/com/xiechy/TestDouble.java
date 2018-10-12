package com.xiechy;

import org.junit.Test;

/**
 * @author xiechy
 * @create 2018-07-16
 * @Descrption
 **/
public class TestDouble {

    public static void main(String[] args) {
        int i =(int)3.6;
        System.out.println("3.9->"+i);
        int j =(int)3.5;
        System.out.println("3.5->"+j);
        int k =(int)3.4;
        System.out.println("3.4->"+k);
        int l =(int)3.1;
        System.out.println("3.1->"+l);

        double test1 = 3.25;
        System.out.println(test1-(int)test1);

        double test2 =4.00;
        System.out.println(test2-(int)test2);


        //向上取整
        double days = 3.1;
        double days1 =3.9;
        double days2 =3.0;
        int intDays = (int)Math.ceil(days);
        System.out.println("3.1->"+intDays);
        int intDays1 = (int)Math.ceil(days1);
        System.out.println("3.9->"+intDays1);
        int intDays2 = (int)Math.ceil(days2);
        System.out.println("3.0->"+intDays2);


    }


    @Test
    public  void test(){
        double total =0.0;
        for(int i =0;i<4;i++){
            if(i==2){
              total +=2.0;
            }else{
                total +=1;
            }
        }
        int out = (int)Math.ceil(total);
        System.out.println(out);

    }

    @Test
    public void test1(){
            String a = "0.0";
            System.out.println(Double.parseDouble(a)<=0);
    }


    @Test
    public void test2() {
        String doubleStr = "11.0";
        if (doubleStr.contains(".")) {
            // String[] strs = doubleStr.split(".");   转义之后就不报错了
            String[] strs = doubleStr.split("\\.");
            System.out.println("strsLen:"+strs.length);
            System.out.println(strs[0]);
            System.out.println(Integer.valueOf(strs[0]));
        }
    }


    @Test
    public void test3() {
        String a = "11.0";
        if (a.contains(".")) {
            String t = a.substring(0, a.indexOf("."));
            System.out.println(Integer.valueOf(t));
        }
    }

    @Test
    public void test4(){
        String d ="11";
        Double dd = Double.valueOf(d);
        System.out.println(dd);
    }

}




    
        