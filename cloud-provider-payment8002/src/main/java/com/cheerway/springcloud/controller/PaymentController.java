package com.cheerway.springcloud.controller;

import com.cheerway.springcloud.entities.CommonResult;
import com.cheerway.springcloud.entities.Payment;
import com.cheerway.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 支付模块控制器
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-06  13:53
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("------插入数据库------" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功, serverPort: " + serverPort);
        } else {
            return new CommonResult<>(400, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("------查询数据库------");
        if (payment != null) {
            return new CommonResult<>(200, "查询成功, serverPort: " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "查询失败：" + id);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
