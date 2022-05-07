package com.shuiyou.service;

import com.shuiyou.domain.All_data;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface MarkService {


    List<String> splitText(String text);

    Object predictReduceEvent(List<String> clauseList);

    Object extract(List<String> reduceList, String text);


    String storageData(Map<String, Object> map);
    /**
     * 测试用例使用
     * @param name
     * @return
     */
    Object test(String name);
}
