package com.huyva.customer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Mẫu regex để kiểm tra số điện thoại
        String regex = "^(0|84|\\+84)\\d{9,10}$";

        // Tạo đối tượng Pattern
        Pattern pattern = Pattern.compile(regex);

        // Tạo đối tượng Matcher
        Matcher matcher = pattern.matcher(phoneNumber);

        // Kiểm tra xem số điện thoại có khớp với mẫu không
        return matcher.matches();
    }
}
