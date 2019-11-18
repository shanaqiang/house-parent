package com.shana.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/18
 * @since 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class HouseRegister_10001 {
    public static void main(String[] args) {
        SpringApplication.run(HouseRegister_10001.class,args);
    }
}

