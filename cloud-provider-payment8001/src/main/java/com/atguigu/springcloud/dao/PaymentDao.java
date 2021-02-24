package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 00:05
 */
@Mapper
public interface PaymentDao {
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
