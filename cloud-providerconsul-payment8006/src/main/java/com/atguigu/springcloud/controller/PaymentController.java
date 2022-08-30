package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Helimin
 * @Date 2022/8/24 17:39
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@EnableDiscoveryClient
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentInfo()
    {
        return "springcloud with consul: "+serverPort+"\t\t"+ UUID.randomUUID().toString();
    }
}
