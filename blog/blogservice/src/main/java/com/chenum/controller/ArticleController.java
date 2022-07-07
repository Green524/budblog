package com.chenum.controller;

import com.chenum.po.Article;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ArticleController {

    @Resource
    private IArticleService iArticleService;

    @RequestMapping("/add")
    public Article hello(@RequestBody(required = false) ArticleVO articleVO){
        return iArticleService.add(articleVO);
    }

}
