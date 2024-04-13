package com.huyva.base.models;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends Exception {
    private int code;

    private HttpStatus httpStatus;
    private ApiException(int code) {
        this.code = code;
        this.httpStatus = HttpStatus.OK;
    }

    public ApiException(int code, String msg, HttpStatus httpStatus) {
        super(msg);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(ERROR msg, HttpStatus httpStatus) {
        super(msg.getMessage());
        this.code = msg.getCode();
        this.httpStatus = httpStatus;
    }

    public ApiException(ERROR msg, String message, HttpStatus httpStatus) {
        super(message);
        this.code = msg.getCode();
        this.httpStatus = httpStatus;
    }

}
