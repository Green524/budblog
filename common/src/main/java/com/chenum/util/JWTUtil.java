package com.chenum.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {

    public static String build(Map<String, Object> payload, int expired,String secret) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, expired);
        JWTCreator.Builder builder = JWT.create().withExpiresAt(instance.getTime());
        if (payload != null){
            payload.forEach((s, o) -> builder.withClaim(s, (String) o));
        }
        return builder.sign(Algorithm.HMAC256(secret));
    }
    public static void verify(String secret,String s){
        JWT.require(Algorithm.HMAC256(secret)).build().verify(s);
    }
}
