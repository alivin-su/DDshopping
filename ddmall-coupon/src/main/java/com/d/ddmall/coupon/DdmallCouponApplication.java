package com.d.ddmall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.d.ddmall.product.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class DdmallCouponApplication {
    public static void main(String[] args) {
        SpringApplication.run(DdmallCouponApplication.class, args);
    }

}
