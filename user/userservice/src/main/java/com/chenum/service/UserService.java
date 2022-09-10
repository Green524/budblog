package com.chenum.service;

import com.chenum.response.Wrapper;
import com.chenum.vo.LoginResponse;
import com.chenum.vo.UserVO;

public interface UserService {
    Wrapper<LoginResponse> login(UserVO userVO);

    Wrapper<Boolean> registry(UserVO userVO);
}
