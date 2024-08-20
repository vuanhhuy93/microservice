package com.huyva.base.common;



public enum ERROR {
    SYSTEM_ERROR(500, "SYSTEM_ERROR", "System Error", "System Error"),
    INVALID_REQUEST(400, "INVALID_REQUEST", "Invalid Request", "Invalid Request"),
    INVALID_PARAMETER(400, "INVALID_PARAMETER", "Invalid Parameter", "Invalid Parameter"),
    USER_BLOCK(1000 , "USER_BLOCK" , "User Block" , "User Block" ),
    LOGIN_FAIL(1001 , "LOGIN_FAIL" , "Login Fail" , "Login Fail"),
    ;
    private int code;
    private String errorCode;
    private String title;
    private String message;


    ERROR(int code, String errorCode, String title, String message) {
        this.code = code;
        this.errorCode = errorCode;
        this.title = title;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

}
