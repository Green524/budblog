package com.chenum;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenum.dao")
@EnableDubbo
public class BlogServiceApplication {
    static{
        System.setProperty("pagehelper.banner", "false");
    }
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class,args);
    }
}
