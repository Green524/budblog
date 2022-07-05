package com.chenum.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello" + name;
    }
}
