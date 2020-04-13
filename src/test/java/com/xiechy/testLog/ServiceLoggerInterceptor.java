package com.xiechy.testLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author kale
 * @Description  日志拦截器，还需要在spring-core.xml配置信息
 * 详情：G:\碳云工作\file\个人\logIntecetor
 * @Date 2018/10/9.
 */
public class ServiceLoggerInterceptor {
    private final static Logger LOG = LoggerFactory.getLogger(ServiceLoggerInterceptor.class);

    public Object output(ProceedingJoinPoint joinPoint) throws Throwable {
        long start, end;
        Object result = null;
        start = System.currentTimeMillis();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        try {
            result = joinPoint.proceed();
        } finally {
            if (LOG.isInfoEnabled()) {
                end = System.currentTimeMillis();
                StringBuffer msg = new StringBuffer();
                msg.append("\n      class : ").append(method.getDeclaringClass().getName());
                msg.append("\n      method : ").append(method.getName());
                msg.append("\n      args : ").append(Arrays.toString(joinPoint.getArgs()));
                msg.append("\n      result : ").append(result);
                msg.append("\n      spent time : ").append(String.valueOf(end - start)).append("ms");
                LOG.info(msg.toString());
            }
        }
        return result;
    }
}
