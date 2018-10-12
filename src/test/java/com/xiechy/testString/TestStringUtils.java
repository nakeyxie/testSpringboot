package com.xiechy.testString;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiechy
 * @create 2018-09-03
 * @Descrption  测试String工具类
 **/
public class TestStringUtils {

    public static void main(String[] args) {
        List<String> testList = Arrays.asList("s1","s2","s3","s4","s5");
        System.out.println(StringUtils.join(testList,'8'));
    }
}




    
        