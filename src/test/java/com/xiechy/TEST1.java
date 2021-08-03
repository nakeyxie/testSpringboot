package com.xiechy;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lenovo on 2017/12/25.
 */
public class TEST1 {
    public static void main(String[] agrs){
/*        List list =Arrays.asList(1,2,3,4);
        List list3 = Arrays.asList("1","2","3","4");
        List list2 = (List) list.stream().map(i->{
            int t = (Integer)i;
            t++;
            System.out.println(t);
            return t;
        }).collect(Collectors.toList());
        System.out.println(list2.toString());
        System.out.println(list3);*/

         //byte可以直接转成int
         Byte test1 = 2;
         int num = 0;
         num = test1;
        System.out.println(num);
    }

    @Test
    public void testSpilt(){
        String tset = "testdasfsdafd4564";
        String[] splits = tset.split(",");
        System.out.println(JSON.toJSONString(splits));
    }
}
