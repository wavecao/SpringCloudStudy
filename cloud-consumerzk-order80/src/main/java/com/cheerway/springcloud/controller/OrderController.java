package com.cheerway.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-07  16:28
 */
@RestController
public class OrderController {
    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment (){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
    }
}
