package com.huyva.base.models;



import com.huyva.base.models.*;
import lombok.Data;


@Data
public class BaseResponse<T> {
    

    private int code;
 

    private String message;

    private T data;
    public BaseResponse() {
        this.code = 1;
        this.message = "SUCCESS";
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public BaseResponse(ERROR msg) {
        this.code = msg.getCode();
        this.message = msg.getMessage();
    }

    public void setCodeSuccess() {
        this.code = 1;
        this.message = "SUCCESS";
    }
}
