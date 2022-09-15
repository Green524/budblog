package com.chenum.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.chenum.dao.UserMapper;
import com.chenum.enums.BaseEnum;
import com.chenum.exception.BusinessException;
import com.chenum.po.User;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.UserService;
import com.chenum.util.JWTUtil;
import com.chenum.util.PasswdUtil;
import com.chenum.vo.LoginResponse;
import com.chenum.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @NacosValue(value = "${secret}",autoRefreshed = true)
    private String secret;
    private static final int EXPIRES = 60 * 60;

    @Override
    public Wrapper<LoginResponse> login(UserVO userVO) {
        String username = userVO.getUsername();
        String passwd = userVO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(passwd)) {
            throw new BusinessException(BaseEnum.PARAMS_ERROR);
        }
        User record = userMapper.selectByUserName(username);
        if (record == null) {
            throw new BusinessException(500, "用户不存在", null);
        }
        String recordPasswd = record.getPassword();
        String userPasswd = PasswdUtil.sha512(passwd);
        System.out.println("secret:" + secret);
        if (recordPasswd.equals(userPasswd)) {
            Map<String, Object> payload = new HashMap<>();
            payload.put("username", record.getUsername());
            payload.put("id", record.getId());
            String token = JWTUtil.build(payload, EXPIRES, secret);
            return WrapMapper.wrap(200, "登录成功!", new LoginResponse(token, EXPIRES));
        }
        return WrapMapper.error("用户名或密码错误!");
    }

    @Override
    public Wrapper<Boolean> registry(UserVO userVO) {
        String username = userVO.getUsername();
        String passwd = userVO.getPassword();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(passwd)) {
            throw new BusinessException(BaseEnum.PARAMS_ERROR);
        }
        User record = userMapper.selectByUserName(username);
        if (record != null) {
            throw new BusinessException(500, "用户名已存在", null);
        }
        record = new User();
        record.setUsername(username);
        record.setPassword(PasswdUtil.sha512(passwd));
        record.setCreateTime(new Date());
        record.setUpdateTime(record.getCreateTime());
        record.setIdentityType((byte) 0);
        int updates = userMapper.insert(record);
        if (updates == 0) {
            throw new BusinessException(BaseEnum.INERT_ERROR);
        }
        return WrapMapper.ok(Boolean.TRUE);
    }

}
