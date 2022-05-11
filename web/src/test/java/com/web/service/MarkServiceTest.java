package com.web.service;

import com.feignApi.clients.PythonClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class MarkServiceTest {


    @Autowired
    PythonClient pythonClient;
    @Test
    void splitText (){
        String text = "财政部 国家税务总局关于增值税几个税收政策问题的通知";

        List<String> list = pythonClient.splitText(text);

        System.out.println(list);
    }
    @Test
    void predictReduceEvent() {
        String text1 = "财政部 国家税务总局关于增值税几个税收政策问题的通知1";
        String text2 = "财政部 国家税务总局关于增值税几个税收政策问题的通知2";
        String text3 = "财政部 国家税务总局关于增值税几个税收政策问题的通知3";
        List<String> list = new ArrayList<>();
        list.add(text1);
        list.add(text2);
        list.add(text3);
        Object object = pythonClient.predictReduceEvent(list);
        System.out.println(object);
    }

    @Test
    void extract() {
        String text = "财政部 国家税务总局关于增值税几个税收政策问题的通知";
        List<String> reduceList = new ArrayList<>();
        String text1 = "财政部 国家税务总局关于增值税几个税收政策问题的通知1";
        String text2 = "财政部 国家税务总局关于增值税几个税收政策问题的通知2";
        reduceList.add(text1);
        reduceList.add(text2);

        Map<String, Object> map = new HashMap<>();
        map.put("reduceList", reduceList);
        map.put("text", text);
        Object object = pythonClient.extract(map);
        System.out.println(object);

    }
}
