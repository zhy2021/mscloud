package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/15 00:19
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/create")
    public CommonResult<?> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("result ==> {},,server port : {}",result,serverPort);
        if (result>0){
            return new CommonResult<>(200,"成功",result);
        }
        return new CommonResult<>(404,"失败",null);
    }

    @GetMapping(value = "/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment ==> {},,server port : {}",payment,serverPort);
        if (payment!=null){
            return new CommonResult<>(200,"成功",payment);
        }
        return new CommonResult<>(404,"失败",null);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
