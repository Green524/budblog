package com.chenum.service;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.vo.ArticleVO;

public interface IArticleService {

    Wrapper<Article> add(ArticleVO articleVO);


    Wrapper<Boolean> del(ArticleVO articleVO);

}
