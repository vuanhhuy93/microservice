package com.huyva.base.utils;

import java.util.regex.Pattern;

public class StringUtils {

    public static String formatPhoneNumber(String phoneNumber){
        if (phoneNumber.startsWith("0"))
            return phoneNumber.replaceFirst("0", "84");

        if (phoneNumber.startsWith("+84")){
            return phoneNumber.replaceFirst(Pattern.quote("+"), "");
        }

        return phoneNumber;
    }

}
