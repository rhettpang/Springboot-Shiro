package com.test.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Created by pangkunkun on 2017/11/15.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.test.shiro.mapper")
public class ShiroDemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class,args);
    }

}