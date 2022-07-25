package com.chenum.controller;

import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class ArticleController {

    @Resource
    private IArticleService iArticleService;

    @PutMapping("/add")
    public Wrapper<Article> add(@RequestBody(required = false) ArticleVO articleVO){
        return iArticleService.add(articleVO);
    }

    @DeleteMapping("/del")
    public Wrapper<Boolean> del(@RequestBody(required = false) ArticleVO articleVO){
        return iArticleService.del(articleVO);
    }

    @GetMapping("/query/page")
    public Wrapper<List<Article>> selectByPage(ArticleVO articleVO){
        return iArticleService.selectByPage(articleVO);
    }



}
