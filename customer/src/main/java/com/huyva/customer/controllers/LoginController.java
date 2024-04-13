package com.huyva.customer.controllers;

import com.huyva.base.models.ApiException;
import com.huyva.base.models.BaseResponse;
import com.huyva.customer.models.request.login.LoginRequest;

import com.huyva.customer.models.response.login.LoginResponse;
import com.huyva.customer.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authen")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping()
    public BaseResponse<LoginResponse> login(@RequestBody LoginRequest request) throws ApiException {
        return loginService.login(request);
    }
}
