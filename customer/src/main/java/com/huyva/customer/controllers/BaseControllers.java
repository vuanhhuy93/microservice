package com.huyva.customer.controllers;


import com.huyva.base.models.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseControllers {
    public ResponseEntity<BaseResponse> returnSuccess() {
        BaseResponse response = new BaseResponse();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> pingping() {

        return new ResponseEntity<>("pong", HttpStatus.OK);
    }

}
