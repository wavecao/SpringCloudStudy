package com.cheerway.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cheerway.springcloud.entities.CommonResult;
import com.cheerway.springcloud.entities.Payment;
import com.cheerway.springcloud.handler.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-15  10:28
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName() + " 服务不可用");
    }

    @GetMapping("/limit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200,"按请求路径限流测试OK",new Payment(2020L,"serial001"));
    }

    @GetMapping("/limit/byCustomHandler")
    @SentinelResource(value = "byCustomHandler",
            blockHandlerClass = CustomBlockHandler.class,
            blockHandler = "handleException2")
    public CommonResult limitByCustomHandler() {
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }
}
