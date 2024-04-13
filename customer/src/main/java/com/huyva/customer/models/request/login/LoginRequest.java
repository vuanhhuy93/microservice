package com.huyva.customer.models.request.login;

import lombok.Data;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
