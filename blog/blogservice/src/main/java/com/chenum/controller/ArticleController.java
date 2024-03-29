package com.chenum.controller;

import com.chenum.annotation.ApiPass;
import com.chenum.po.Article;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleResponseVO;
import com.chenum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/blog")
public class ArticleController {

    @Resource
    private IArticleService iArticleService;

    @PostMapping("/add")
    public Wrapper<ArticleResponseVO> add(@RequestBody ArticleVO articleVO){
        return iArticleService.add(articleVO);
    }

    @PutMapping("/update")
    public Wrapper<ArticleResponseVO> update(@RequestBody ArticleVO articleVO){
        return iArticleService.updateOne(articleVO);
    }

    @DeleteMapping("/del/{id}")
    public Wrapper<Boolean> del(@PathVariable String id){
        return iArticleService.del(id);
    }
    @GetMapping("/admin/query/page")
    public Wrapper<PageInfo<Article>> adminQueryPage(ArticleVO articleVO){
        return iArticleService.adminQueryPage(articleVO);
    }

    @GetMapping(value = "/query/page")
    @ApiPass
    public Wrapper<PageInfo<ArticleResponseVO>> selectByPage(ArticleVO articleVO){
        return iArticleService.selectByPage(articleVO);
    }


    @GetMapping("/query/{id}")
    @ApiPass
    public Wrapper<ArticleResponseVO> query(@PathVariable String id){
        return iArticleService.query(id);
    }

}
