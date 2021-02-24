package com.atguigu.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/14 23:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 看注册的信息
public class paymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(paymentMain8001.class,args);
    }
}
