package com.chenum.dao;

import com.chenum.po.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment row);

    int insertSelective(Comment row);

    Comment selectByPrimaryKey(String id);

    List<Comment> selectSelective(Comment row);

    int updateByPrimaryKeySelective(Comment row);

    int updateByPrimaryKey(Comment row);
}