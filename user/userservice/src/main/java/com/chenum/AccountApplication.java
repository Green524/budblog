package com.chenum;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;


@SpringBootApplication
@MapperScan(basePackages = "com.chenum.dao")
@EnableDubbo
public class AccountApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AccountApplication.class,args);
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
