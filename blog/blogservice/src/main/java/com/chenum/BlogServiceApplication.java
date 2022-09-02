package com.chenum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.chenum.dao")
//@EnableConfigurationProperties
public class BlogServiceApplication {
    static{
        System.setProperty("pagehelper.banner", "false");
    }
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class,args);
    }
}
