package com.chenum.dubbo.service.impl;

import com.chenum.dubbo.service.IUserService;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.util.JWTUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

@DubboService
public class DubboUserServiceImpl implements IUserService {
    @Override
    public Wrapper<Boolean> authVerify(String secret, String s) {
        System.out.println("Hello " + secret + ", request from consumer: " + RpcContext.getServerContext().getRemoteAddress());
        System.out.println("Hello " + secret + ", request from consumer: " + RpcContext.getServiceContext().getRemoteAddress());
        System.out.println("Hello " + secret + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        try {
            JWTUtil.verify(secret,s);
        }catch (Exception e){
            return WrapMapper.wrap(403,e.getMessage(),Boolean.FALSE);
        }
        return WrapMapper.ok(Boolean.TRUE);
    }
}
