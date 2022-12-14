package com.guoba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9901 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9901.class,args);
    }
}
