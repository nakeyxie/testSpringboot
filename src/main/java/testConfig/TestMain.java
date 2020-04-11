package testConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 通过配置的方式
 * 加载Bean
 */
public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestBeanConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        bean.say();
    }
}
