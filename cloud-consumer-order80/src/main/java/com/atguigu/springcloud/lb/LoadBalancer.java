package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Helimin
 * @Date 2022/8/25 16:47
 * @Description: TODO
 * @Version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
