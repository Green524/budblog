package com.chenum.service;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.vo.ArticleResponseVO;
import com.chenum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IArticleService {

    Wrapper<ArticleResponseVO> add(ArticleVO articleVO);


    Wrapper<Boolean> del(ArticleVO articleVO);


    Wrapper<PageInfo<ArticleResponseVO>> selectByPage(ArticleVO articleVO);

    Wrapper<ArticleResponseVO> updateOne(ArticleVO articleVO);


    Wrapper<ArticleResponseVO> query( String id);

}
