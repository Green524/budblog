package com.chenum.controller;

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

    @PostMapping("/login")
    public Wrapper<LoginResponse> login(@RequestBody UserVO userVO){
        return userService.login(userVO);
    }


    @PutMapping("/registry")
    public Wrapper<Boolean> registry(@RequestBody UserVO userVO){
        return userService.registry(userVO);
    }
}
