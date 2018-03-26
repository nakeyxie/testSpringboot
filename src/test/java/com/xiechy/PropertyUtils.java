import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import java.lang.reflect.InvocationTargetException;

/**
 * @author xiechy
 * @create 2018-01-19
 * @Descrption
 **/
public class PropertyUtils {

    /**
     * 获取对象属性
     * @param o  对象
     * @param field 字段名
     * @return reuslt  字段值
     * @throws Exception
     */
    public static Object getProperty(Object o, String field) throws Exception {
        Object reuslt = null;
        try {
            reuslt = BeanUtilsBean.getInstance().getPropertyUtils().getProperty(o, field);
        } catch (IllegalAccessException e) {
            throw new Exception("getProperty fail IllegalAccess");
        } catch (InvocationTargetException e) {
            throw new Exception("getProperty fail InvocationTarget");
        } catch (NoSuchMethodException e) {
            throw new Exception("getProperty fail NoSuchMethod");
        }
        return reuslt;
    }

    /**
     * 设置对象属性
     * @param o 对象
     * @param field 属性
     * @param value 属性值
     * @throws Exception
     */
    public static void setProperty(Object o, String field, Object value) throws Exception {
        try {
            BeanUtils.setProperty(o, field, value);
        } catch (IllegalAccessException e) {
            throw new Exception("setProperty fail IllegalAccess");
        } catch (InvocationTargetException e) {
            throw new Exception("setProperty fail InvocationTarget");
        }
    }
}




    
        