package com.xiechy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiechy
 * @create 2018-01-19
 * @Descrption
 **/
public class PropertyUtils {

    private final static int FAIL_CODE = ErrorCode.FAIL.getErrorCode();


    /**
     * 获取对象属性
     *
     * @param o     对象
     * @param field 字段名
     * @return reuslt  字段值
     * @throws Exception
     */
    public static Object getProperty(Object o, String field) throws BusinessException {
        Object reuslt = null;
        try {
            reuslt = BeanUtilsBean.getInstance().getPropertyUtils().getProperty(o, field);
        } catch (IllegalAccessException e) {
            throw new BusinessException(FAIL_CODE, "getProperty fail IllegalAccess");
        } catch (InvocationTargetException e) {
            throw new BusinessException(FAIL_CODE, "getProperty fail InvocationTarget");
        } catch (NoSuchMethodException e) {
            throw new BusinessException(FAIL_CODE, "getProperty fail NoSuchMethod");
        }
        return reuslt;
    }

    /**
     * 获取对象字符属性
     *
     * @param o     对象
     * @param field 字段名
     * @return reuslt  字段值
     * @throws Exception
     */
    public static String getStrProperty(Object o, String field) throws BusinessException {
        String reuslt = null;
        try {
            reuslt = BeanUtils.getSimpleProperty(o, field);
        } catch (IllegalAccessException e) {
            throw new BusinessException(FAIL_CODE, "getStrProperty fail IllegalAccess");
        } catch (InvocationTargetException e) {
            throw new BusinessException(FAIL_CODE, "getStrProperty fail InvocationTarget");
        } catch (NoSuchMethodException e) {
            throw new BusinessException(FAIL_CODE, "getStrProperty fail NoSuchMethod");
        }
        return reuslt;
    }

    /**
     * 设置对象属性
     * @param o     对象
     * @param field 属性
     * @param value 属性值
     * @throws Exception
     */
    public static void setProperty(Object o, String field, Object value) throws BusinessException {
        try {
            BeanUtils.setProperty(o, field, value);
        } catch (IllegalAccessException e) {
            throw new BusinessException(FAIL_CODE, "setProperty fail IllegalAccess");
        } catch (InvocationTargetException e) {
            throw new BusinessException(FAIL_CODE, "setProperty fail InvocationTarget");
        }
    }

    /**
     * 获取对象所有属性
     * 除了serialVersionUID
     */
    public static String[] getAllFieldNames(Object o){
        List<String>  fieldNames = new ArrayList<String>();
        try {
            Class clazz = o.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                String fieldName = field.getName();
                if("serialVersionUID".equals(fieldName)){
                    continue;
                }
                fieldNames.add(field.getName());
            }
        } catch (Exception e) {
            throw new BusinessException(FAIL_CODE, "getAllFieldNames fail!");
        }
        return  fieldNames.toArray(new String[0]);
    }

    /**
     * 获取枚举的所有属性和中文描述
     * @param Enum
     * @param methodName
     * @return
     */
    public static Map<String,String> getEnumFields(String Enum,String methodName){
        Map<String,String> enumFieldMap = new HashMap<String,String>();
        try {
            Class clazz = Class.forName(Enum);
            if(!clazz.isEnum()){
                return  enumFieldMap;
            }
            //得到enum的所有实例
            Object[]  enumFields = clazz.getEnumConstants();
            //获取枚举对应意思的方法有待统一
            Method method =clazz.getMethod(methodName);
            for(Object enumField : enumFields){
                String value =enumField.toString();
                Object name = method.invoke(enumField);
                enumFieldMap.put(value,name.toString());
            }
        } catch (Exception e) {
            throw new BusinessException(FAIL_CODE, "getEnumFields fail!");
        }
        return  enumFieldMap;
    }

    public static void main(String[] args) {
        testGetEnumMsg();
        System.out.println("----------");
        String [] names =getAllFieldNames(new User());
        for (String name : names){
            System.out.print(name);
            System.out.print("   ");
        }

    }

    public static void testGetEnumMsg(){
       Map<String,String> enumFieldMap = getEnumFields("com.xiechy.BatchContorlState","getText");
        for(Map.Entry<String,String> entry :enumFieldMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }


}




    
        