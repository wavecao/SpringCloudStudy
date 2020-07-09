package com.cheerway.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-08  20:37
 */
public interface LoadBalancer {

    /**
     * 获取Eureka中所有可用的服务列表，并且返回其中一个
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
