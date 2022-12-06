package com.guoba.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zzyy
 * @create 2019-12-27 12:50
 */
@Configuration
public class ApplicationContextConfig
{
    @Bean
//    @LoadBalanced //赋予restTemplate负载均衡的能力
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
