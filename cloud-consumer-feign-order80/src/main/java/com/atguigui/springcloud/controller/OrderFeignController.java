package com.atguigui.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigui.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 21:01
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getPaymentById/{id}")
    CommonResult<?> getPaymentById(@PathVariable("id") Long id){
        System.out.println(123);
       return paymentFeignService.getPaymentById(id);
    }
}
