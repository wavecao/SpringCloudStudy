package com.cheerway.springcloud.service;

import com.cheerway.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * PaymentService
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-06  13:50
 */
public interface PaymentService {
    /**
     * 插入一条支付数据
     * @param payment 支付实体类
     * @return 影响的行数
     */
    int create(Payment payment);

    /**
     * 根据id查询支付信息
     * @param id id
     * @return 支付实体类
     */
     Payment getPaymentById(@Param("id") Long id);
}
