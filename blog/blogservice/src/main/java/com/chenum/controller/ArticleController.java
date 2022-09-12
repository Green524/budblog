package com.chenum.controller;

import com.chenum.annotation.ApiPass;
import com.chenum.dubbo.service.IUserService;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.service.IArticleService;
import com.chenum.vo.ArticleResponseVO;
import com.chenum.vo.ArticleVO;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/blog")
public class ArticleController {

    @Resource
    private IArticleService iArticleService;
    @DubboReference
    private IUserService iUserService;

    @PostMapping("/add")
    public Wrapper<ArticleResponseVO> add(@RequestBody ArticleVO articleVO){
        System.out.println(articleVO);
        return iArticleService.add(articleVO);
    }
    @PutMapping("/update")
    public Wrapper<ArticleResponseVO> update(@RequestBody ArticleVO articleVO){
        return iArticleService.updateOne(articleVO);
    }

    @DeleteMapping("/del")
    public Wrapper<Boolean> del(@RequestBody ArticleVO articleVO){
        System.out.println(articleVO);
        return iArticleService.del(articleVO);
    }

    @GetMapping("/query/page")
    @ApiPass
    public Wrapper<PageInfo<ArticleResponseVO>> selectByPage(ArticleVO articleVO){
        return iArticleService.selectByPage(articleVO);
    }


    @GetMapping("/query/{id}")
    @ApiPass
    public Wrapper<ArticleResponseVO> query(@PathVariable String id){
        return iArticleService.query(id);
    }


    @GetMapping("/get")
    @ApiPass
    public Wrapper<String> getAddr(HttpServletRequest request){
        System.out.println(iUserService);
        return WrapMapper.ok(iUserService.sayHello("cpq"));
    }
}
