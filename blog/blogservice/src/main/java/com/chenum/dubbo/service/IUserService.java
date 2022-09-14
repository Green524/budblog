package com.chenum.dubbo.service;

import com.chenum.response.Wrapper;

public interface IUserService {

    Wrapper<Boolean> authVerify(String secret, String s);
}
