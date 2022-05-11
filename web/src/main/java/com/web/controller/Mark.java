package com.web.controller;



import com.web.controller.utils.Result;
import com.web.controller.vo.Extract;
import com.web.controller.vo.StorageData;
import com.web.controller.vo.ClauseList;
import com.web.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web")
public class Mark {

    @Autowired
    MarkService markService;

    @GetMapping("/markSplit")
    public Result splitText(String text) {
        List<String> list = markService.splitText(text);
        Result result = new Result();
        result.setFlag(true);
        result.setData(list);
        result.setMsg("分割成功！");
        return result;
    }

    @PostMapping("/markReduceEvent")
    public Result predictReduceEvent(@RequestBody ClauseList clauseList) {
        Object map = markService.predictReduceEvent(clauseList.getData());
        Result result = new Result();
        result.setFlag(true);
        result.setData(map);
        result.setMsg("识别成功！");

        return result;
    }

    @PostMapping("/markExtract")
    public Result extract(@RequestBody Extract extract) {
        Object extractData = markService.extract(extract.getData(), extract.getText());
        Result result = new Result();
        result.setFlag(true);
        result.setData(extractData);
        result.setMsg("抽取成功！");
        return result;
    }


    @PostMapping("/markStorageData")
    public Result storageData(@RequestBody StorageData storageData) {
        String res = markService.storageData(storageData.getData(), storageData.getText());
        Result result = new Result();
        result.setFlag(true);
        result.setData(res);
        result.setMsg(res);
        return result;
    }



    /**
     * 使用了本地测试python注册nacos服务的功能
     * 目前对于本项目正式功能来说无效
     * @param name
     * @return
     */
    @GetMapping("/markTest/{name}")
    public Result test(@PathVariable("name") String name) {
        Object test = markService.test(name);
        Result result = new Result();
        result.setFlag(true);
        result.setData(test);
        result.setMsg("成功！");
        return result;
    }
}
