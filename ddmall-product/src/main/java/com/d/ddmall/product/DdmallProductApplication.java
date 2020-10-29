package com.d.ddmall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.整合Mybatis-plus
 *      1）导入依赖
 *      <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.4.0</version>
 *      </dependency>
 *      2）配置
 *          配置数据源
 *              导入数据库驱动，驱动写到common里
 *              在application.yml配置数据源相关信息
 *          配置mybatis-plus
 *              使用@MapperScan
 *              告诉mybatis-plus，sql映射文件位置
 */


@SpringBootApplication
public class DdmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmallProductApplication.class, args);
    }

}
