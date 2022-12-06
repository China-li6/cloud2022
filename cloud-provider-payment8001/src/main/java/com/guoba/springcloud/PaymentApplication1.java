package com.guoba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //开启服务发现
public class PaymentApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication1.class,args);
    }
}
