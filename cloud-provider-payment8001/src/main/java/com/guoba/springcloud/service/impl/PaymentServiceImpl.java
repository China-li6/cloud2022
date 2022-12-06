package com.guoba.springcloud.service.impl;

import com.guoba.springcloud.dao.PaymentDao;
import com.guoba.springcloud.entities.Payment;
import com.guoba.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource//Java中的自动注入
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
