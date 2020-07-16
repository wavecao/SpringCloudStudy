package com.cheerway.springcloud.service;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-16  10:28
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
