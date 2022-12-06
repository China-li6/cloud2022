package com.guoba.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_OK,id: "+id+"\t"+"O(∩_∩)O";
    }

    /**
     * 超市
     * @param id
     * @return
     */
    //服务降级 fallback 兜底
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")//定义该线程超时时间 3秒
    })
    public String paymentInfo_TimeOut(Integer id) {
        //int age = 10/0;
        int timeNumber = 4;
        try { TimeUnit.SECONDS.sleep(timeNumber); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }


    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {


        return "调用接口超时异常/(ㄒoㄒ)/~~，当前线程池名字："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id: "+id+"\t"+"O(-_-)O，耗时不止3秒";
    }

}
