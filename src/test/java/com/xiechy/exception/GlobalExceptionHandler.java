package com.xiechy.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kale
 * @Description
 * @Date 2018/1/31.
 *
 *
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    //处理自定义的异常
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object businessExceptionHandler(BusinessException e){
        log.error("businessException :{}",e);
        return ApiResult.error(e.getCode(), e.getMessage());
    }
    //其他未处理的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        log.error("exception :{}",e);
        return ApiResult.error(ErrorCode.FAIL.getErrorCode(), "系统异常");
    }
}
