package com.shuiyou.service;

import com.shuiyou.domain.All_data;

import java.util.List;
import java.util.Map;

public interface MarkService {


    List<String> splitText(String text);

    Map<String, List<String>> predictReduceEvent(List<String> clauseList);

    All_data extract(List<String> reduceList);

    Object test(String name);
}
