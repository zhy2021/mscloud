package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/23 20:13
 */
@Mapper
public interface OrderDao {
    /**
     * TODO: 新建订单
     * 
     * @author: Zhang hao yu
     * @param order
     * @return: void
     */
    void create(Order order);

    /**
     * TODO: 修改订单，从0到1
     *
     * @author: Zhang hao yu
     * @param userId
     * @param status
     * @return: void
     */
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
