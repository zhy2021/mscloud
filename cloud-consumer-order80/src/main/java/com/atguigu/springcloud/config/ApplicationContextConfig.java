package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 11:20
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced // 开启负载均衡，否则微服务名称中不能正常使用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
