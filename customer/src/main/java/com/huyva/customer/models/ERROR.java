package com.huyva.customer.models;

import org.springframework.http.HttpStatus;

public enum ERROR {
    SUCCESS(1, "SUCCESS"),
    USER_NOT_VIP(4, "Tài khoản không có quyền thực hiện chức năng này, vui lòng nâng cấp tài khoản"),
    LOGIN_FAIL(10, "Tên đăng nhập hoặc mật khẩu không đúng"),
    SYSTEM_ERROR(99, "Hệ thống đang nâng cấp tính năng này , xin vui lòng thử lại sau !"),

    GRPC_SERVICE_ERROR(500, "Hệ thống đang gián đoạn, xin vui lòng thử lại sau!"),
    RESTAPI_SERVICE_ERROR(500, "Hệ thống đang gián đoạn, xin vui lòng thử lại sau!"),
    INVALID_DATA(01, "Dữ liệu không hợp lệ!"),
    CAPTCHA_INVALID(100, "Mã captcha không hợp lệ!"),
    IP_BLOCKED(101, "Địa chỉ ip bị khóa do nhập sai quá nhiều!"),
    USER_NOT_FOUND(102, "Người dùng không tồn tại!"),
    USER_BLOCKED(103, "Tài khoản đã bị khóa , vui lòng liên hệ với quản trị viên!"),
    PASSWORD_FAIL(104, "Mật khẩu không đúng!"),
    USER_NOT_MAP(105, "Thông tin người dùng chưa có trên hệ thống. Vui lòng đăng ký tài khoản!"),
    USER_LOCKED(106, "Tài khoản đã bị khóa , vui lòng liên hệ với quản trị viên!"),
    BUSINESS_LOCKED(107, "Tài khoản đã bị khóa , vui lòng liên hệ với quản trị viên!"),
    USER_NOT_EXISTED(108, "Thông tin tài khoản không tồn tại"),
    USER_HAVE_NOT_BUSINESS(109, "Tài khoản chưa có thông tin doanh nghiệp"),
    TAX_CODE_HAS_REGISTER(110, "Thông tin Mã số thuế của doanh nghiệp đã được đăng kí"),
    TOKEN_INVALID(112, "Token không hợp lệ hoặc đã hết hạn"),
    USER_NOT_GRANT_BUSINESS(113, "Tài khoản này chưa được gán với một doanh nghiệp , xin vui lòng đăng ký để được sử dụng dịch vụ!"),
    USER_BLOCK_LOGIN(114, "Tài khoản này đang bị khóa vì nhập quá số lần sai mật khẩu , xin vui lòng đăng nhập lại sau : "),


    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    ERROR(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiException ERR() {
        return new ApiException(this, HttpStatus.BAD_REQUEST);
    }
}
