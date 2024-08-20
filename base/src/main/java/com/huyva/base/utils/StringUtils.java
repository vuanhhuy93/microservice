package com.huyva.base.utils;

public class StringUtils {

    public static String formatPhoneNumber(String phoneNumber){
        if (phoneNumber.startsWith("0")){
            return phoneNumber.replaceFirst("0", "+84");
        }

        if (phoneNumber.startsWith("84")){
            return phoneNumber.replaceFirst("84", "+84");
        }

        return phoneNumber;
    }
}
