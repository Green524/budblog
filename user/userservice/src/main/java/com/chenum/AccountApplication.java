package com.chenum;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(basePackages = "com.chenum.dao")
@NacosPropertySource(dataId = "testDataId", autoRefreshed = true)
@EnableNacosDiscovery
public class AccountApplication {
    @NacosInjected
    private NamingService namingService;

//    @PostConstruct
//    public void registerInstance() throws NacosException {
//        namingService.registerInstance("1","127.0.0.1",8848);
//    }
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
