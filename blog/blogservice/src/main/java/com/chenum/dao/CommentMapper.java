package com.chenum.dao;

import com.chenum.po.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment row);

    int insertSelective(Comment row);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment row);

    int updateByPrimaryKey(Comment row);
}