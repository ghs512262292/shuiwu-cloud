package com.web;

import com.feignApi.clients.PythonClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 在把feign模块独立出来后，不要忘记把客户端的扫描加上，佛则启动可能会报错
// 我这里是由于两个模块的的包凑是com.shuiyou，因此不加也可以扫描上，按规范还是需要加上
@EnableFeignClients(clients = PythonClient.class)
@SpringBootApplication
// 开启缓存功能
@EnableCaching
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


}
