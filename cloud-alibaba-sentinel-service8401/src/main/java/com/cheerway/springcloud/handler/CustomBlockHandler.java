package com.cheerway.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cheerway.springcloud.entities.CommonResult;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-15  10:55
 */
public class CustomBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息1....CustomerBlockHandler---1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息2....CustomerBlockHandler---2");
    }
}
