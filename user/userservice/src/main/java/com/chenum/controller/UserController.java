package com.chenum.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.UserService;
import com.chenum.vo.LoginResponse;
import com.chenum.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @NacosValue(value = "${secret:test}",autoRefreshed = true)
    private String secret;


    @PostMapping("/login")
    public Wrapper<LoginResponse> login(@RequestBody UserVO userVO){
        return userService.login(userVO);
    }


    @PutMapping("/registry")
    public Wrapper<Boolean> registry(@RequestBody UserVO userVO){
        return userService.registry(userVO);
    }

    @GetMapping("/get")
    public Wrapper<String> get(){
        return WrapMapper.ok(secret);
    }
}
