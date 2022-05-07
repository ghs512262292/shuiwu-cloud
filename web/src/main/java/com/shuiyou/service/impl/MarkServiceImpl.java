package com.shuiyou.service.impl;

import com.shuiyou.clients.PythonClient;
import com.shuiyou.domain.All_data;
import com.shuiyou.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    PythonClient pythonClient;
    @Override
    public List<String> splitText(String text) {
        List<String> list = pythonClient.splitText(text);
        return list;
    }

    @Override
    public Object predictReduceEvent(List<String> clauseList) {
        Object object = pythonClient.predictReduceEvent(clauseList);
        return object;
    }

    @Override
    public Object extract(List<String> reduceList, String text) {
        Map<String, Object> map = new HashMap<>();
        map.put("reduceList", reduceList);
        map.put("text", text);
        Object object = pythonClient.extract(map);
        return object;
    }

    @Override
    public String storageData(Map<String, Object> map) {
        String res = pythonClient.storageData(map);
        return res;
    }


    @Override
    public Object test(String name) {
        Object o = pythonClient.splitText(name);
        return o;
    }
}
