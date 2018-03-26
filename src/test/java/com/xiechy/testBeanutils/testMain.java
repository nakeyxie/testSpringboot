package com.xiechy.testBeanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author xiechy
 * @create 2018-01-19
 * @Descrption
 **/
public class testMain {

    public static void main(String[] args) {
        Person  p = new Person();
        p.setId(1);
        p.setName("nakey");
        p.setAddr("sz");
        String [] buys = {"one","two","three","four"};
        p.setBuyList(Arrays.asList(buys));
        System.out.println(p.toString());
        System.out.println("-----------------");
        int id=0;
        Object name="";
        Object addr ="";
        Object buyList="";
        try {
            id=(Integer) BeanUtilsBean.getInstance().getPropertyUtils().getProperty(p,"id");
            name =BeanUtilsBean.getInstance().getPropertyUtils().getProperty(p,"name");
            addr =BeanUtilsBean.getInstance().getPropertyUtils().getProperty(p,"addr");
            buyList=BeanUtilsBean.getInstance().getPropertyUtils().getProperty(p,"buyList");

        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        } catch (NoSuchMethodException e) {

        }

        System.out.println("id="+id);
        System.out.println("addr="+addr);
        System.out.println("name:"+name);
        System.out.println("buyList:"+buyList);

        System.out.println("------------------");
        try {
            String [] buyNew = {"one","two","three","454"};
            BeanUtils.setProperty(p,"id",50);
            BeanUtils.setProperty(p,"addr","yulin");
            BeanUtils.setProperty(p,"name","xcy");
            BeanUtils.setProperty(p,"buyList",Arrays.asList(buyNew));
            BeanUtils.setProperty(p,"buyList","bye");
        } catch (IllegalAccessException e) {

        } catch (InvocationTargetException e) {

        }
        System.out.println("设置属性");
         System.out.println(p.toString());

    }

}




    
        