package com.shuiyou.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// 这个注解定义服务名称
@FeignClient("python-service")
public interface PythonClient {
    @GetMapping("/simulation/analysis/{name}")
    Object testPython(@PathVariable("name") String name);

}
