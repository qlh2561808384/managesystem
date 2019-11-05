package com.longgroup.managesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.longgroup.managesystem.mapper")
@SpringBootApplication
public class ManagesystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagesystemApplication.class, args);
    }

}
