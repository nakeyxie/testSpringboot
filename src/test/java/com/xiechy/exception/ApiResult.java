package com.xiechy.exception;

import java.io.Serializable;


/**
 * 返回数据基类，快速调用
 *
 *  <pre>
 *  return ApiResult.success();
 *  return ApiResult.success(data);
 *  return ApiResult.success().data(data);
 *  return ApiResult.error(code, message);
 *  return ApiResult.error(code, message, data);
 *  return ApiResult.error(code, message).data(data);
 *  </pre>
 * 移除了{com.icarbonx.commons.BaseResp}的分页参数,其他参数和{com.icarbonx.commons.BaseResp}一致
 * <br />
 *
 * 返回分页示例
 *
 * <pre>
 * PageData pageData = new PageData(pageNum,pageSize,totalSize,dataList) ();
 * ApiResult<PageData> result = ApiResult.success(pageData);
 * </pre>
 * 参考{com.icarbonx.commons.pagination.PageData}
 *
 * @author wei
 *
 */
public class ApiResult<T> implements Serializable {

    public static ApiResult success() {
        return new ApiResult();
    }

    public static <T> ApiResult<T> success(T data) {
        return (new ApiResult()).data(data);
    }

    public static ApiResult error(int code, String message) {
        return new ApiResult(code, message);
    }

    public static <T> ApiResult<T> error(int code, String message, T data) {
        return new ApiResult(code, message).data(data);
    }

    /**
     * 返回码， 0标示成功，其他参考错误码定义类
     */
    private int errorCode;
    /**
     * 错误信息，默认为空字符串
     */
    private String errMsg;
    /**
     * 系统的时间戳**用于矫正手机本地时间不准的问题
     */
    private long timestamp;

    private T data;

    public ApiResult() {
        timestamp = System.currentTimeMillis();
    }

    /**
     * @param errorCode
     * @param errMsg
     */
    public ApiResult(int errorCode, String errMsg) {
        this();
        this.errorCode = errorCode;
        this.errMsg = errMsg;
    }

    /**
     * 用错误码构造返回
     *
     * @param errorCode
     */
    public ApiResult(int errorCode) {
        this(errorCode, ErrorCode.getMsg(errorCode));
    }

    /**
     * @param errorCode
     */
    public ApiResult(ErrorCode errorCode) {
        this(errorCode.getErrorCode(), errorCode.getErrorMsg());
    }


    /**
     * 根据com..constans.ErrorCode 定义的错误信息，设置code，msg
     *
     * @param define 必须为已定义的错误码，不然会出现-1错误码
     */
    public ApiResult(String define) {
        this(ErrorCode.getCode(define), ErrorCode.getMsg(define));

    }

    /**
     * 根据com..constans.ErrorCode 定义的错误信息，设置code，msg
     *
     * @param define 必须为已定义的错误码，不然会出现-1错误码
     */
    public void setErrorCodeAndMsg(String define) {
        this.errorCode = ErrorCode.getCode(define);
        this.errMsg = ErrorCode.getMsg(define);
    }

    /**
     * 设置返回0，空错误信息
     */
    public void setSuccessReturn() {
        this.errorCode = 0;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode0(int errorCode) {
        this.errorCode = errorCode;
        this.errMsg = ErrorCode.getMsg(errorCode);
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.errMsg = errorCode.getErrorMsg();
    }

    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param errMsg the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public ApiResult data(T data) {
        this.setData(data);
        return this;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ApiResult<T> throwIfError(){
        if(errorCode != 0 ){
            throw new BusinessException(this.errorCode, this.errMsg);
        }
        return this;
    }

}