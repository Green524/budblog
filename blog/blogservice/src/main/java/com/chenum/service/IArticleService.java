package com.chenum.service;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.vo.ArticleVO;

import java.util.List;

public interface IArticleService {

    Wrapper<Article> add(ArticleVO articleVO);


    Wrapper<Boolean> del(ArticleVO articleVO);


    Wrapper<List<Article>> selectByPage(ArticleVO articleVO);

    Wrapper<Article> updateOne(ArticleVO articleVO);


    Wrapper<Article> query( String id);

}
