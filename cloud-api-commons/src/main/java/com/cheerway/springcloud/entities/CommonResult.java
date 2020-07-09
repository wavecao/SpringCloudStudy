package com.cheerway.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-06  11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    /**
     * 无数据的返回
     * @param code 状态码
     * @param message 信息
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
