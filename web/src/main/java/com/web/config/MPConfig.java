package com.web.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 使用配置类进行mybatis的配置
 * 首先由于这是基于springboot的因此要使用注解 Configuration 来进行
 * 在内部进行Bean的注解
 */

@Configuration
public class MPConfig {
    /**
     * 拦截器方法,支撑分页查询
     * @return
     */

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 1.定义Mp拦截器（总拦截器，负责承载其他拦截器）
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 2.添加分页功能的拦截器,之后用到其他的还可以加入其他的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }


    /**
     * 临时定义RestTemplate去请求flask服务的数据
     * 等待后期以别的方式进行改进
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
