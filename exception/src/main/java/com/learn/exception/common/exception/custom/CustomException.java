package com.learn.exception.common.exception.custom;

/**
 * @author lijy
 * @create 2019-06-01 21:56
 * @description
 */
public class CustomException extends RuntimeException {
    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
