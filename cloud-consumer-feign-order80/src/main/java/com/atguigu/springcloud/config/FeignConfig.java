package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Helimin
 * @Date 2022/8/26 12:29
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }

}
