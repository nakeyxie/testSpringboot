package com.xiechy.distinct;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiechy
 * @create 2018-03-21
 * @Descrption
 **/
public class TestLamdaDistinct {
    public static void main(String[] args) {
        int [] testDistinct= new int[]{1,2,2,3,4,5,3,6,7,5,7,8,9,8};
        List arrList =Arrays.asList(testDistinct);
        System.out.println("用Arrays.asList不可以打印出来集合的详细："+arrList);
        List testList = new ArrayList<String>();
        for(int i :testDistinct){
            testList.add(i);
        }
        System.out.println("new的list可以打印集合的详细："+testList);
        List<String> result = new ArrayList<String>();
        result = (ArrayList)testList.stream().map(i->i.toString()).distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    //不用distinct().之前的代码
    /*
    Set<String> itemSet = new HashSet<String>();
    itemList.stream().forEach(i->{
        //存不重复的检测项编码+检测项名称
        itemSet.add(i.getExperimentItem()+","+i.getExperimentItemName());
    });
    for(String item : itemSet){
        String[] items =item.split(",");
        ExperimentPackItemPO itemPO = new ExperimentPackItemPO();
        itemPO.setItemCode(items[0]);
        itemPO.setName(items[1]);
        experimentItemPOs.add(itemPO);

    }*/
}




    
        