package com.xiechy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-03-06
 * @Descrption
 **/
public class TestT<T> {

    private String name;

    private int id;

    //加入泛型T，需要在類前加<T> 這樣才能用
    private T data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

class  Main{
    public static void main(String[] args) {
        TestT   test = new TestT();
        Object o = new Object();
        test.setData(o);

        Object o1 = new Object();
        Object[] o2 ={o,o1};
        test.setData(o2);

        List list = new ArrayList<>();
        test.setData(list);

        //强转
        List testGet = (List<String>)test.getData();
        //輸出list 不用toString方法
        System.out.println(testGet);
    }

}




    
        