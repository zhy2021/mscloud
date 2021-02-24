package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/18 17:29
 */
@Component
public class FeignHyStrixFallback implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "=========paymentInfo_OK=========";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "=========paymentInfo_TimeOut=========";
    }
}
