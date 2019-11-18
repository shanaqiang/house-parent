package com.shana.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/18
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class HouseGateway_10010 {
    public static void main(String[] args) {
        SpringApplication.run(HouseGateway_10010.class,args);
    }
}

