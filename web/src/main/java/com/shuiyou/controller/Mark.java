package com.shuiyou.controller;



import com.shuiyou.controller.utils.Result;
import com.shuiyou.domain.All_data;
import com.shuiyou.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mark")
public class Mark {

    @Autowired
    MarkService markService;

    @PostMapping("/split")
    public Result splitText(String text) {
        List<String> list = markService.splitText(text);
        Result result = new Result();
        result.setFlag(true);
        result.setData(list);
        result.setMsg("分割成功！");
        return result;
    }

    @GetMapping("/reduceEvent")
    public Result predictReduceEvent(List<String> clauseList) {
        Map<String, List<String>> map = markService.predictReduceEvent(clauseList);
        Result result = new Result();
        result.setFlag(true);
        result.setData(map);
        result.setMsg("识别成功！");
        return result;
    }

    @GetMapping("/extract")
    public Result extract(List<String> reduceList) {
        All_data extractData = markService.extract(reduceList);
        Result result = new Result();
        result.setFlag(true);
        result.setData(extractData);
        result.setMsg("抽取成功！");
        return result;
    }


    /**
     * 使用了本地测试python注册nacos服务的功能
     * 目前对于本项目正式功能来说无效
     * @param name
     * @return
     */
    @GetMapping("/test/{name}")
    public Result test(@PathVariable("name") String name) {
        Object test = markService.test(name);
        Result result = new Result();
        result.setFlag(true);
        result.setData(test);
        result.setMsg("成功！");
        return result;
    }
}
