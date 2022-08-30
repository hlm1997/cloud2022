package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author Helimin
 * @Date 2022/8/26 12:34
 * @Description: TODO
 * @Version 1.0
 */
@Service
public class PaymentService {

    /**
     * 正常访问,一切ok
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: " + Thread.currentThread().getName() + "paymentInfo_OK，id" + id + "\t" + "☺";
    }

    /**
     * 超时访问,演示降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费3秒";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }
}
