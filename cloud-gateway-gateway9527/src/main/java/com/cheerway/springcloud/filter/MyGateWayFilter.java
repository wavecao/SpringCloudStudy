package com.cheerway.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author : 曹威
 * @since : 2020-07-10  15:21
 */
@Component
@Slf4j
public class MyGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("------进入了自定义全局过滤器------" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (StringUtils.isEmpty(username)) {
            log.info("非法请求，已被拒绝  /(ㄒoㄒ)/~~");
            //设置响应的状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            exchange.getResponse().setComplete();
        }
        log.info(username + "请求了地址，已被允许  (●'◡'●)");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
