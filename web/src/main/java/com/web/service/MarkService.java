package com.web.service;

import java.util.List;
import java.util.Map;

public interface MarkService {


    List<String> splitText(String text);

    Object predictReduceEvent(List<String> clauseList);

    Object extract(List<String> reduceList, String text);


    String storageData(List<Map<String, Object>> data, String text);
    /**
     * 测试用例使用
     * @param name
     * @return
     */
    Object test(String name);
}
