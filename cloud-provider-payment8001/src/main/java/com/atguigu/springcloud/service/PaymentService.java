package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 00:16
 */
public interface PaymentService {
    /**
     * TODO: 插入
     *
     * @author: Zhang hao yu
     * @param payment
     * @return: int
     */
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
