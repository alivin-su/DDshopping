package com.d.ddmall.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DdmallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmallWareApplication.class, args);
    }

}
