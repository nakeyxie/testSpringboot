package com.xiechy.code;



import org.springframework.util.Assert;

import java.util.Collection;

/**
 * @ClassName UseAssert
 * @Description spring Assert 用法
 *
 * @Author xcy
 * @Date 2021/4/14 13:44
 */
public class UseAssert {

    public static void main(String[] args) {
        /**
         * Spring Assert用法
         */
        String a=null;
        //判断a是不是null 为null则抛出异常
        Assert.notNull(a,"a为null");


//      int b=1;
        //判断b等于1  不等于1就抛出异常；
//      Assert.isTrue(b!=1,"b不等于1");

//      List<String> list=new ArrayList<String>();
        //当集合未包含元素时抛出异常。
//      Assert.notEmpty(list,"list没有元素");

//      String string="";
        //当 string 为 null 或长度为 0 时抛出异常；
//      Assert.hasLength(string,"text为null或者空");

        String string="";
        //text 不能为 null 且必须至少包含一个非空格的字符，否则抛出异常；
        Assert.hasText(string,"string为null或者没有包含非空格字符");
    }


  /*  总结借鉴：
            1. notNull(Object object)
　　当 object 不为 null 时抛出异常，notNull(Object object, String message) 方法允许您通过 message 定制异常信息。和 notNull() 方法断言规则相反的方法是 isNull(Object object)/isNull(Object object, String message)，它要求入参一定是 null；

    isTrue(boolean expression) / isTrue(boolean expression, String message)
　　当 expression 不为 true 抛出异常；

    notEmpty(Collection collection) / notEmpty(Collection collection, String message)
　　当集合未包含元素时抛出异常。
            　　notEmpty(Map map) / notEmpty(Map map, String message) 和 notEmpty(Object[] array, String message) / notEmpty(Object[] array, String message) 分别对 Map 和 Object[] 类型的入参进行判断；

    hasLength(String text) / hasLength(String text, String message)
　　当 text 为 null 或长度为 0 时抛出异常；

    hasText(String text) / hasText(String text, String message)
　　text 不能为 null 且必须至少包含一个非空格的字符，否则抛出异常；

    isInstanceOf(Class clazz, Object obj) / isInstanceOf(Class type, Object obj, String message)
　　如果 obj 不能被正确造型为 clazz 指定的类将抛出异常；

    isAssignable(Class superType, Class subType) / isAssignable(Class superType, Class subType, String message)
　　subType 必须可以按类型匹配于 superType，否则将抛出异常；
            ————————————————
    版权声明：本文为CSDN博主「淡乄然」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/hcwbr123/article/details/79820259*/

}
