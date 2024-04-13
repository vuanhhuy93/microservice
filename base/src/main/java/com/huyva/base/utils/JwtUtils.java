package com.huyva.base.utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Map;

@Log4j2
public class JwtUtils {

    private static Long expiredTime;

    private static String key;

    public static void loadData(Long expiredTimeConfig, String keyConfig){
        expiredTime = expiredTimeConfig;
        key = keyConfig;
    }
    public static String buildJWTLogin(Map<String, Object> data){

        JwtBuilder builder =  Jwts.builder();
        builder.setSubject("user-login")
                .setIssuer("SYSTEM").setClaims(data);

        builder.setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime));

        builder.signWith(
                SignatureAlgorithm.HS256,
                TextCodec.BASE64.decode(key));
        return builder.compact();
    }
}
