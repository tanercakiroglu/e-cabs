package com.example.ecabs.exception;

public class BusinessException extends RuntimeException {

    private String code;
    private String message;

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
