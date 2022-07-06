package com.chenum.dao;

import com.chenum.po.Music;

public interface MusicMapper {
    int deleteByPrimaryKey(String id);

    int insert(Music row);

    int insertSelective(Music row);

    Music selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Music row);

    int updateByPrimaryKey(Music row);
}