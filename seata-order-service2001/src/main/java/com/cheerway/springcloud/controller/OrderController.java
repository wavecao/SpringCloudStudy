package com.cheerway.springcloud.controller;

import com.cheerway.springcloud.domain.CommonResult;
import com.cheerway.springcloud.domain.Order;
import com.cheerway.springcloud.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-16  10:11
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
