/**
 * @author xiechy
 * @create 2018-01-02
 * @Descrption
 **/
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -1450841463269L;
    private Object[] messageArguments;
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

    public synchronized Throwable fillInStackTrace() {
        return null;
    }

    public Object[] getMessageArguments() {
        return this.messageArguments;
    }

    public void setMessageArguments(Object[] messageArguments) {
        this.messageArguments = messageArguments;
    }

    public int getCode() {
        return this.code;
    }

}




    
        