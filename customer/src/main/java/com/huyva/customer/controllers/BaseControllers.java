package com.huyva.customer.controllers;

import com.huyva.customer.models.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseControllers {
    protected ResponseEntity<BaseResponse> returnSuccess() {
        BaseResponse response = new BaseResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
