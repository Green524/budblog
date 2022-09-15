package com.chenum.dubbo.service.impl;

import com.chenum.dubbo.service.IUserService;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.util.JWTUtil;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DubboUserServiceImpl implements IUserService {
    @Override
    public Wrapper<String> authVerify(String secret, String s) {
        try {
            JWTUtil.verify(secret,s);
            return WrapMapper.ok("true");
        }catch (Exception e){
            return WrapMapper.wrap(403,e.getMessage(),"false");
        }
    }
}
