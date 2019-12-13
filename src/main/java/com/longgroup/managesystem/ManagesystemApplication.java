package com.longgroup.managesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.longgroup.managesystem.mapper")
@SpringBootApplication
//@EnableTransactionManagement//Spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可。
public class ManagesystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagesystemApplication.class, args);
    }

}
