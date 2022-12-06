package com.guoba.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther zzyy
 * @create 2020-01-31 12:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006 {
    public static void main(String[] args)
    {
        SpringApplication.run(Payment8006.class,args);
    }
}
