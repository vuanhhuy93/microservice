package com.huyva.customer.models.response;



import com.huyva.customer.models.ERROR;
import lombok.Data;


@Data
public class BaseResponse {
    

    private int code;
 

    private String message;
    
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
