package com.guoba.springcloud.controller;

import com.guoba.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/order/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallBack",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeout",value = "1500")//1.5s未响应则判定为超时
    })//80客户端运行出错兜底方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentInfoTimeOutFallBack(@PathVariable("id") Integer id)
    {
        return "/(ㄒoㄒ)/~~我是消费者80，对方支付系统繁忙请稍后再试或自己运行出错请检查自己/(ㄒoㄒ)/~~";
    }

}
