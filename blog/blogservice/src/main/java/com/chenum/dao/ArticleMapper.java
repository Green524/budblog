package com.chenum.dao;

import com.chenum.po.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article row);

    int insertSelective(Article row);

    Article selectByPrimaryKey(String id);

    List<Article> selectByPage(Map<String,Object> row);

    int updateByPrimaryKeySelective(Article row);

    int updateByPrimaryKey(Article row);
}