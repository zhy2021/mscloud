package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/23 20:20
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "tx_create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---> 开始新建订单");
        orderDao.create(order);
        log.info("---> 开始调用库存，扣减库存--start");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---> 开始调用库存，扣减库存--end");

        log.info("---> 开始调用用户余额，扣减与余额--start");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---> 开始调用用户余额，扣减与余额--end");

        // 修改订单状态，0到1,完成
        log.info("修改订单状态");
        orderDao.update(order.getUserId(),1);

        log.info("新建订单完成");
    }

}
