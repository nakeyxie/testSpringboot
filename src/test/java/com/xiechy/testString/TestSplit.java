package com.xiechy.testString;

//import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author xiechy
 * @create 2018-09-17
 * @Descrption
 **/
public class TestSplit {

    //测试类里面嵌套一个类
    public class Test2{
       public  final String a1="1";
    }


    public static void main(String[] args) {
        /*String inspectNo ="123456";
        List<String> inspectNos = Lists.newArrayList(inspectNo.split("\\s+"));
        System.out.println(inspectNos);*/

        TestSplit t = new TestSplit();
    }

    @Test
    public void testConvert(){
        String[] testNum ={"1.904493088E9", "1.9042776E9", "1.904493017E9"};
        for (int i=0;i<testNum.length;i++){
            System.out.println(testNum[i]);
            String[] testNum1 = testNum[i].split("E");
            double d =Double.parseDouble(testNum1[0]);
            int e = Integer.parseInt(testNum1[1]);
            int result =(int) (d * Math.pow(10,e));
            String str = String.valueOf(result);
            System.out.println(str);
        }

    }
}




    
        