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

    @PostMapping("/add")
    public Wrapper<Article> add(@RequestBody ArticleVO articleVO){
        System.out.println(articleVO);
        return iArticleService.add(articleVO);
    }
    @PutMapping("/update")
    public Wrapper<Article> update(@RequestBody ArticleVO articleVO){
        return iArticleService.updateOne(articleVO);
    }

    @DeleteMapping("/del")
    public Wrapper<Boolean> del(@RequestBody ArticleVO articleVO){
        System.out.println(articleVO);
        return iArticleService.del(articleVO);
    }

    @GetMapping("/query/page")
    public Wrapper<List<Article>> selectByPage(@RequestBody ArticleVO articleVO){
        return iArticleService.selectByPage(articleVO);
    }


    @GetMapping("/query/{id}")
    public Wrapper<Article> query(@PathVariable String id){
        return iArticleService.query(id);
    }

}
