package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author Helimin
 * @Date 2022/8/30 21:56
 * @Description: TODO
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_ok,(╥╯^╰╥)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_timeout,(╥╯^╰╥)";
    }
}
