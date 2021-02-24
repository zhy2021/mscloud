package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;
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

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        log.info("*****element: {}",services);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance :
                instances) {
            log.info(instance.getServiceId());
            log.info(instance.getHost());
            log.info(String.valueOf(instance.getPort()));
            log.info(String.valueOf(instance.getUri()));
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/zipkin")
    public String getPaymentZipkin(){
        return "zipkin..............";
    }
}
