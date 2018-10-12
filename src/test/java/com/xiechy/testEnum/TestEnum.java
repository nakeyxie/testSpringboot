package com.xiechy.testEnum;

/**
 * @author xiechy
 * @create 2018-09-21
 * @Descrption
 **/
public class TestEnum {

    public static void main(String[] args) {
        System.out.println(Container.PORE_PLATE.name());
        int totalSize =0;
        int t = totalSize % getPageSize() > 0?totalSize / getPageSize() + 1:totalSize / getPageSize();
    }

    public static  int getPageSize(){
        return 0;
    }
}




    
        