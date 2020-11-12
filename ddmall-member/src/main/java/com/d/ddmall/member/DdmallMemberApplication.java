package com.d.ddmall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.d.ddmall.member.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class DdmallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(DdmallMemberApplication.class, args);
    }

}
