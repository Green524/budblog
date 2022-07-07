package com.chenum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenum.dao")
public class BlogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class,args);
    }
}
