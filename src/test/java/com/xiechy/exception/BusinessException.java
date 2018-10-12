/**
 * 
 */
package com.xiechy.exception;


/**
 * @author zhuangzhaowen on 2016年5月9日
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1450841463269L;

	private Object[] messageArguments ;

	private int code;

	public BusinessException() {
	}

	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(ErrorCode errorCode) {
		this(errorCode.getErrorCode(), errorCode.getErrorMsg());
	}

	@Override
	/**
	 * 业务异常不需要堆栈信息， 重写该方法以提高性能
	 */
	public synchronized Throwable fillInStackTrace() {
		return null;
	}

	public Object[] getMessageArguments() {
		return messageArguments;
	}

	public void setMessageArguments(Object[] messageArguments) {
		this.messageArguments = messageArguments;
	}

	public int getCode() {
		return code;
	}
}
