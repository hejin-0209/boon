package com.boon.reward_and_punishment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  关于这个类的描述
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class RewardApplication {

    public static void main(String[] args) {
        SpringApplication.run(RewardApplication.class,args);
    }
}
