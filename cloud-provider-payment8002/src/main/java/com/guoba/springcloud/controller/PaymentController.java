package com.guoba.springcloud.controller;


import com.guoba.springcloud.entities.CommonResult;
import com.guoba.springcloud.entities.Payment;
import com.guoba.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**********************插入结果："+result);
        if (result >0){
            return new CommonResult(200,"插入数据成功！端口号："+serverPort,result);
        }else {
            return new CommonResult(500,"添加失败！！！端口号："+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("*********************查询结果"+payment);
        if (!Objects.isNull(payment)){
            return new CommonResult(200,"查询成功！端口号："+serverPort,payment);
        }else {
            return new CommonResult(500,"查询失败!查询id:"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
