package com.chenum.dao;

import com.chenum.po.About;

public interface AboutMapper {
    int deleteByPrimaryKey(String id);

    int insert(About row);

    int insertSelective(About row);

    About selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(About row);

    int updateByPrimaryKey(About row);
}