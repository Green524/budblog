package com.chenum.dubbo.service.impl;

import com.chenum.dubbo.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

@DubboService
public class DubboUserServiceImpl implements IUserService {
    @Override
    public String sayHello(String name) {
        System.out.println("Hello " + name + ", request from consumer: " + RpcContext.getServerContext().getRemoteAddress());
        return "Hello " + name;
    }
}
