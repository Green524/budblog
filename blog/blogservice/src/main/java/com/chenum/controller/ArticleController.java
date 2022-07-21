package com.chenum.controller;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/blog")
public class ArticleController {

    @Resource
    private IArticleService iArticleService;

    @RequestMapping(value = "/add")
    public Wrapper<Article> hello(@RequestBody(required = false) ArticleVO articleVO){
        return iArticleService.add(articleVO);
    }



}
