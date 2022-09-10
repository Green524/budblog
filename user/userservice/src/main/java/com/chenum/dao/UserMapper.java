package com.chenum.dao;

import com.chenum.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(String id);

    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}