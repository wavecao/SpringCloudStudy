package com.cheerway.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-16  10:12
 */
@Configuration
@MapperScan({"com.cheerway.springcloud.dao"})
public class MyBatisConfig {
}
