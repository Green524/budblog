package com.chenum.dao;

import com.chenum.po.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article row);

    int insertSelective(Article row);

    Article selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article row);

    int updateByPrimaryKey(Article row);
}