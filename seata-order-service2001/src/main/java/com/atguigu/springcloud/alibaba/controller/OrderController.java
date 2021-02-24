package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/23 20:45
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        System.out.println("123123123");
        orderService.create(order);

        return new CommonResult(200,"订单创建成功");
    }

    @GetMapping("/test")
    public void test(){
        System.out.println(123123);
    }
}
