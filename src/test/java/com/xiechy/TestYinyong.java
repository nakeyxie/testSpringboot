package com.xiechy;

import com.xiechy.code.User;
import org.junit.Test;

/**
 * @author xiechy
 * @create 2018-04-02
 * @Descrption 测试引用关系
 **/
public class TestYinyong {

    public static void main(String[] args) {
        TestYinyong  t = new TestYinyong();
        User u = t.test(new User());
        System.out.println(u.toString());
    }

    public User test(User user) {
        setId(user);
        System.out.println("中间");
        System.out.println(user.toString());
        setName(user);
        return user;
    }

    private void setName(User user) {
        user.setName("test");
        //引用指向新对象后就是一个新的地址,原来user不受影响
        user = new User(40 ,"testNew");
    }

    private void setId(User user) {

        user.setId(99);
    }


    /**
     * 由于String类和包装类都没有提供value对应的setter方法，我们无法改变其内容，所以导致我们看起来好像是值传递。
     *
     * 总结一下java中方法参数的使用情况：

     一个方法不能修改一个基本数据类型的参数(即数值型和布尔型)
     一个方法可以改变一个对象参数的状态
     ***一个方法不能让对象参数引用一个新的对象***
     */
    @Test
    public void testInteger() {
        Integer integer = new Integer(5);
        testchange(integer);
        //输出结果还是5
        System.out.println(integer);
    }

    private void testchange(Integer integer) {
        integer =new Integer(8);
        //这里输出结果是8
        System.out.println("方法里面的integer:"+integer);

    }

    @Test
    public void testYingYong() {

        User u1 = null;
        User u2 = null;
        for (int i = 0; i < 5; i++) {
            User u = new User();
            u.setName("test" + i);
            if (u1 == null) {
                u1 = u;
                u2 = u1;
            } else {
                u1 =u;
            }
        }
        System.out.println(u2);
        System.out.println(u1);

    }

    // += 后面不能跟null
    @Test
    public void testDoubleAdd(){
        User u = new User();
        double d = 0;
        if(u != null){
            d += u.getSarlay();
        }
    }

}




    
        