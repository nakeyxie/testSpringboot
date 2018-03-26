package com.xiechy.testBeanutils;

import java.util.List;

/**
 * @author xiechy
 * @create 2018-01-19
 * @Descrption
 **/
public class Person {

    private String name;

    private int id;

    private String addr;

    private List<String> buyList;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<String> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<String> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", addr='" + addr + '\'' +
                ", buyList=" + buyList +
                '}';
    }
}




    
        