package com.huyva.customer.utils;

public interface Constant {

    class ONOFF {
        public static final int ON = 1;
        public static final int OFF = 0;
    }

    class HEADER {
        public static final String TOKEN_PREFIX = "bearer ";
        public static final String HEADER_TOKEN = "Authorization";
        public static final String REQUEST_ID = "x-request-id";
        public static final String DEVICE_ID = "x-device-id";
        public static final String USER_ID_HEADER = "x-authenticated-userid";
        public static final String BUSINESS_ID = "x-business-id";
        public static final String traceId = "X-B3-TraceId";
        public static final String DEVICE_Id = "device-id";
        public static final String I_CHECK_ID = "iCheck-id";
        public static final String TOKEN_HEADER = "x-authentication-token";
    }



    class USER_STATUS {
        public static final int DISABLE = 0;
        public static final int ENABLE = 1;

    }

    class JWT_DATA{
       public static String JWT_ACTION = "action";

        String JWT_ACTION_LOGIN_VALUE = "LOGIN";
    }




}
