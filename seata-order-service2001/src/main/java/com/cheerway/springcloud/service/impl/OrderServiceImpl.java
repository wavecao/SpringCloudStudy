package com.cheerway.springcloud.service.impl;

import com.cheerway.springcloud.dao.OrderDao;
import com.cheerway.springcloud.domain.Order;
import com.cheerway.springcloud.service.AccountService;
import com.cheerway.springcloud.service.OrderService;
import com.cheerway.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-16  10:03
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------开始新建订单------");
        orderDao.create(order);

        log.info("------调用storageService，开始扣减库存------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------扣减库存完成------");

        log.info("------调用accountService，开始扣减余额------");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------扣减余额完成------");

        log.info("------开始更改订单状态------");
        orderDao.update(order.getUserId(), 0);
        log.info("------订单状态修改完成------");

        log.info("------订单业务结束啦！！！------");
    }
}
