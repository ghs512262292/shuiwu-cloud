package com.feignApi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 使用配置类进行mybatis的配置
 * 首先由于这是基于springboot的因此要使用注解 Configuration 来进行
 * 在内部进行Bean的注解
 */

@Configuration
public class DefaultFeignConfiguration {

    /**
     * 设置feign的日志级别
     * @return
     */
    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.BASIC;
    }
}
