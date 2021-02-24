package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * TODO: 手写论询算法
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 19:26
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
