package com.cheerway.springcloud.service.impl;

import com.cheerway.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-09  21:39
 */
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService: 这里是 ok 的统一服务降级处理, (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService: 这里是 timeout 的统一服务降级处理, (┬＿┬)";
    }
}
