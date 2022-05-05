package com.shuiyou.service.impl;

import com.shuiyou.domain.All_data;
import com.shuiyou.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<String> splitText(String text) {

        String host = "47.105.158.15";
        String port = "9001";
        String url = "http://" + host + ":" + port + "/hello?initialText=" + text;
        String s = restTemplate.getForObject(url, String.class);

        return null;
    }

    @Override
    public Map<String, List<String>> predictReduceEvent(List<String> clauseList) {
        return null;
    }

    @Override
    public All_data extract(List<String> reduceList) {
        return null;
    }
}
