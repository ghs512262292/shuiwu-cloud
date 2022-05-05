package com.shuiyou.controller;



import com.shuiyou.controller.utils.Result;
import com.shuiyou.domain.All_data;
import com.shuiyou.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
