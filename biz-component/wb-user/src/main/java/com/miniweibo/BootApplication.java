package com.miniweibo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaoshun.cxs
 * 2020/8/24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.miniweibo.**.dao")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
