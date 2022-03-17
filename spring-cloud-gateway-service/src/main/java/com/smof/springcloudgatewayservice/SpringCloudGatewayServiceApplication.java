package com.smof.springcloudgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudGatewayServiceApplication {

    @Bean
    @LoadBalanced
    public WebClient.Builder builder(){
        return  WebClient.builder();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayServiceApplication.class, args);
    }

}
