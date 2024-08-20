package com.huyva.base.common;

public class ValidationUtils {

    public static boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("^(\\+84|0)\\d{9,10}$");
    }
}
