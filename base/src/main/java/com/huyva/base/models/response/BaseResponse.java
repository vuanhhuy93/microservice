package com.huyva.base.models.response;

import com.huyva.base.common.ERROR;
import lombok.Data;

@Data
public class BaseResponse{

    private int code;
    private String message;
    private String errorCode;

    public BaseResponse(int code, String message, String errorCode) {
        this.code = code;
        this.message = message;
        this.errorCode = errorCode;
    }

    public BaseResponse() {

        this.code = 200;
        this.message = "Success";
        this.errorCode = "SUCCESS";
    }

    public BaseResponse(ERROR error) {

        this.code = error.getCode();
        this.message = error.getMessage();
        this.errorCode = error.getErrorCode();
    }

}
