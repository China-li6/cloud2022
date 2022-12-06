package com.guoba.springcloud.controller;

import com.guoba.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")//配置全局降级兜底方法
public class PaymentHystirxController
{
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/timeout/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
//        int i = 1/0;//手动制造异常
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80,对方支付系统繁忙,请10秒钟后再试或者自己运行出错,请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全部fallback方法
     *
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常全局处理信息，请稍后再试！(￣(工)￣)";
    }

}






