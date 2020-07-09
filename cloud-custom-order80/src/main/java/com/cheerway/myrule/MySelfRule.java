package com.cheerway.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-08  14:46
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //定义规则为随机
        return new RandomRule();
    }
}
