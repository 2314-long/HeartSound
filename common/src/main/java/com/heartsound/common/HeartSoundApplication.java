package com.heartsound.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.heartsound.common.user.mapper")
@SpringBootApplication
public class HeartSoundApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeartSoundApplication.class,args);
    }
}
