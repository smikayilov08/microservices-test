package com.smof.springcloudgatewayservice.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class CustomFilter implements GlobalFilter {

    @Autowired
    private WebClient.Builder builder;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exchange.getRequest().getPath().toString().equals("/api/v1/login") ||
                exchange.getRequest().getPath().toString().equals("/api/v1/signup") ) {

            return chain.filter(exchange);

        } else {

            String jwt;

            try {
                jwt = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            }
            catch (NullPointerException e){
                throw new NullPointerException("Token not found");
            }

            return builder.build().get()
                    .uri("http://localhost:8070/check-token")
                    .header("Authorization", jwt)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .map(s -> {
                        return exchange;
                    })
                    .flatMap(chain::filter)
                    ;
        }
    }
}
