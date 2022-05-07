package com.shuiyou.clients;

import com.shuiyou.controller.Mark;
import com.shuiyou.domain.All_data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


// 这个注解定义服务名称
@FeignClient("python-service")
public interface PythonClient {
    @GetMapping("/simulation/analysis/{name}")
    Object testPython(@PathVariable("name") String name);
    @GetMapping("/split/{text}")
    List<String> splitText(@PathVariable("text") String text);
    @PostMapping("/reduce_event")
    Object predictReduceEvent(List<String> reduceList);

    @PostMapping("/last_result")
    Object extract(@RequestBody Map<String, Object> map);

    @PostMapping("/storage_data")
    String storageData(@RequestBody Map<String, Object> map);

}
