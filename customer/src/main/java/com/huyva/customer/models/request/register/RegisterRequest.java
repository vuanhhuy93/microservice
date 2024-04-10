package com.huyva.customer.models.request.register;

import lombok.Data;

@Data
public class RegisterRequest {
    private String phoneNumber;
    private String email;
    private String password;
    private String confirmPassword;
}
