package com.cheerway.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-13  15:47
 */
@RestController
@Slf4j
public class FlowLimitController
{
    @GetMapping("/testA")
    public String testA() {
        //try {
        //    TimeUnit.MILLISECONDS.sleep(1800);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }




    @GetMapping("/testD")
    public String testD() {
        //测试平均响应时间熔断
        //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        //log.info("testD 测试RT");

        //测试异常比例熔断
        //log.info("testD 测试异常比例");
        //int a = 10 / 0;

        //测试异常数熔断
        log.info("testD 测试异常数");
        int age = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        //int age = 10/0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }




}