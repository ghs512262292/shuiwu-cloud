package com.shuiyou.controller;


import com.shuiyou.controller.utils.Result;
import com.shuiyou.domain.All_data;
import com.shuiyou.domain.vo.enjoy.EnjoyQueryVo;
import com.shuiyou.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query")
public class Query {

    @Autowired
    private QueryService queryService;

    @GetMapping("/showData")
    public Result getAllData(Integer currPage, Integer size) {
        List<All_data> all_data = queryService.selectPageAll(currPage, size);
        // 根据定义的前后端数据协议来返回数据
        Result result = new Result();
        result.setFlag(true);
        result.setData(all_data);
        result.setMsg("查询成功！");
        return result;
    }

    @GetMapping("/enjoy")
    public Result getEnjoyData(String name) {
        EnjoyQueryVo enjoyQueryVo = queryService.selectEnjoy(name);
        Result result = new Result();
        result.setFlag(true);
        result.setData(enjoyQueryVo);
        result.setMsg("查询成功！");
        return result;
    }


//-----------------------------------------------------------------------------------------------
    /**
     * 原生的mybatis-plus的分页查询，但是由于业务不同，目前是自己实现的sql分页查询
     * 可以看看后续有没有可以优化的地方
     * 目前把前代码进行注释
     * 对应原 ： showData 代码
     */
//    @GetMapping("/showData")
//    public Result getAllData(Integer currPage, Integer size) {
//        // 根据定义的前后端数据协议来返回数据
//        IPage page = queryService.selectPageAll(currPage, size);
//        // 如果查询的页面大于全部的页面，那么返回最后一页的页面
//        if (currPage > page.getPages()) {
//            page = queryService.selectPageAll((int)page.getPages(), size);
//        }
//        Result result = new Result();
//        result.setFlag(true);
//        result.setData(page.getRecords());
//        result.setMsg("查询成功！");
//        return result;
//    }
}
