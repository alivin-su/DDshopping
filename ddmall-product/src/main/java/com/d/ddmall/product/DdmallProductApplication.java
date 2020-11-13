package com.d.ddmall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 *
 * 2.逻辑删除
 *    1) 配置全局的逻辑删除规则(省略)
 *    2) 配置逻辑删除的组件Bean(省略)
 *    3) 给Bean加上逻辑删除注解 @TableLogic
 */


@SpringBootApplication
@EnableDiscoveryClient
public class DdmallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmallProductApplication.class, args);
    }

}
