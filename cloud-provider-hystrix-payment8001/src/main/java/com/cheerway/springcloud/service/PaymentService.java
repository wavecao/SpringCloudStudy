package com.cheerway.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-09  15:43
 */
@Service
public class PaymentService {


    public String paymentInfoOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"哈哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id){
        //int age = 10 / 0;

        int timeNumber = 2;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"呜呜呜"+" 耗时(秒): "+timeNumber;
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut, 调用失败了，触发服务降级 /(ㄒoㄒ)/~~";
    }

}
