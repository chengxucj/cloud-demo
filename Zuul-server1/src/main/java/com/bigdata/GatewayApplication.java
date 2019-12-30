package com.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy// 开启Zuul的网关功能
@SpringBootApplication
public class GatewayApplication {

    public static  void main(String[] args){
        SpringApplication.run(GatewayApplication.class);
    }
}