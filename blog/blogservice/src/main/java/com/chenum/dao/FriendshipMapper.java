package com.chenum.dao;

import com.chenum.po.Friendship;

public interface FriendshipMapper {
    int deleteByPrimaryKey(String id);

    int insert(Friendship row);

    int insertSelective(Friendship row);

    Friendship selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Friendship row);

    int updateByPrimaryKey(Friendship row);
}