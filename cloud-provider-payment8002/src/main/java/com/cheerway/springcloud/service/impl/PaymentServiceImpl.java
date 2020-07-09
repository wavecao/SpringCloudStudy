package com.cheerway.springcloud.service.impl;

import com.cheerway.springcloud.dao.PaymentDao;
import com.cheerway.springcloud.entities.Payment;
import com.cheerway.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * PaymentService实现类
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-06  13:51
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
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
