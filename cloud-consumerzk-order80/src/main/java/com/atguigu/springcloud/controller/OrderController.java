package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 15:35
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/getzk")
    public String getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk/",String.class);
    }
}
