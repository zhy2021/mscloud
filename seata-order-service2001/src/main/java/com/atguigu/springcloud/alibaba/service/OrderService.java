package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/23 20:19
 */
public interface OrderService {

    void create(Order order);

}
