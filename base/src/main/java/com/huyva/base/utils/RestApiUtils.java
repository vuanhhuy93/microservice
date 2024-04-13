package com.huyva.base.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;



import java.net.URL;

public class RestApiUtils {




    public static String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader(Constant.HEADER.HEADER_TOKEN);

        if (StringUtils.isBlank(token)) return null;

        token = token.replaceFirst("(?i)" + Constant.HEADER.TOKEN_PREFIX, "");

        return token;
    }

    public static Long getAccountId(HttpServletRequest request) {

        try {
            String headerValue = request.getHeader(Constant.HEADER.USER_ID_HEADER);
            if (StringUtils.isEmpty(headerValue))
                return 0L;
            return Long.parseLong(headerValue);
        } catch (Exception e){
            return 0L;
        }
    }

    public static Long getICheckId(HttpServletRequest request) {

        try {
            String headerValue = request.getHeader(Constant.HEADER.I_CHECK_ID);
            if (StringUtils.isEmpty(headerValue))
                return 0L;
            return Long.parseLong(headerValue);
        } catch (Exception e){
            return 0L;
        }
    }

    public static long getBusinessId(HttpServletRequest request) {

        try {
            String headerValue = request.getHeader(Constant.HEADER.BUSINESS_ID);
            if (StringUtils.isEmpty(headerValue))
                return 0L;
            return Long.parseLong(headerValue);
        } catch (Exception e){
            return 0L;
        }
    }

    public static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getIPRequest(HttpServletRequest servletRequest) {
        if (servletRequest == null)
            return null;
        String remote_iPAddress = null;
        remote_iPAddress = servletRequest.getHeader("X-FORWARDED-FOR");
        if (remote_iPAddress == null || "".equals(remote_iPAddress)) {
            remote_iPAddress = servletRequest.getRemoteAddr();
        }

        return remote_iPAddress;
    }
}
