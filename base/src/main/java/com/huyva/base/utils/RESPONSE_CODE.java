package com.huyva.base.utils;

public interface RESPONSE_CODE {
    class GRPC {
        public static Integer SUCCESS = 0;
        public static Integer FAIL = 1;
    }

    class API {
        public static Integer SUCCESS = 200;
        public static Integer SYSTEM_ERROR = 500;
    }
}
