package com.shana.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*30)
public class HouseProducer_8081 {
    public static void main(String[] args) {
        SpringApplication.run(HouseProducer_8081.class,args);
    }
}

