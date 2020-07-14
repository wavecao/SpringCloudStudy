package com.cheerway.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

}