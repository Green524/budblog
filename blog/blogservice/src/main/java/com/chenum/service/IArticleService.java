package com.chenum.service;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IArticleService {

    Wrapper<Article> add(ArticleVO articleVO);


    Wrapper<Boolean> del(ArticleVO articleVO);


    Wrapper<PageInfo<Article>> selectByPage(ArticleVO articleVO);

    Wrapper<Article> updateOne(ArticleVO articleVO);


    Wrapper<Article> query( String id);

}
