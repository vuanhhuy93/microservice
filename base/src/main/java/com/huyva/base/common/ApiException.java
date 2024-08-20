package com.huyva.base.common;

import lombok.Data;


import java.util.Map;

@Data
public class ApiException extends RuntimeException{
    private int code;
    private String errorCode;
    private String title;
    private Map<String, Object> data;

    private int httpStatus = 0;


    public ApiException(ERROR error) {
        super(error.getMessage());
        this.code = error.getCode();
        this.errorCode = error.getErrorCode();
        this.title = error.getTitle();
        this.httpStatus = 400;
    }

    public ApiException(ERROR error, int httpStatus) {
        super(error.getMessage());
        this.code = error.getCode();
        this.errorCode = error.getErrorCode();
        this.title = error.getTitle();
        this.httpStatus = httpStatus;
    }

    public ApiException(ERROR error, String title, String message, int httpStatus) {
        super(message);
        this.code = error.getCode();
        this.errorCode = error.getErrorCode();
        this.title = title;
        this.httpStatus = httpStatus;
    }

    public ApiException(ERROR error, String message, int httpStatus) {
        super(message);
        this.code = error.getCode();
        this.errorCode = error.getErrorCode();
        this.title = message;
        this.httpStatus = httpStatus;
    }
}
