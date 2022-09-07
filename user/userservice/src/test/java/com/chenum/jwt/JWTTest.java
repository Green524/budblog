package com.chenum.jwt;

import com.chenum.util.JWTUtil;
import org.junit.Test;


public class JWTTest {

    @Test
    public void gen(){
        String token = JWTUtil.build(null,30,"1234");
        JWTUtil.verify("1234",token);
    }
}
