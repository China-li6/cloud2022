package com.guoba.springcloudalibaba.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * 流量限制控制器
 * @auther zzyy
 * @create 2020-01-09 16:34
 */
@RestController
public class FlowLimitController
{

    private static final Logger log = LoggerFactory.getLogger(FlowLimitController.class);

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }
    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }
}