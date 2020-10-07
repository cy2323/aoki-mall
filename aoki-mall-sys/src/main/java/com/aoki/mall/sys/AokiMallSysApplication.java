package com.aoki.mall.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.aoki.mall.sys.repository")
@SpringBootApplication
public class AokiMallSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(AokiMallSysApplication.class, args);
    }

}
