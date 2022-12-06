package com.guoba.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter,Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("***************------------MyLogGateWayFilter!!!!!!!!-------------*********************"+new Date());
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            log.info("非法用户 /(ㄒoㄒ)/~~ -----");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//不接受
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);//续传下去
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
