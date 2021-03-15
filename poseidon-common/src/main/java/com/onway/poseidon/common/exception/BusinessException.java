package com.onway.poseidon.common.exception;

/**
 * @author: fuheng
 * @date: 2021/3/11 9:06
 * @description: 自定义异常
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
