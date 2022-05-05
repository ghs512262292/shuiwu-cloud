package com.shuiyou.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootTest
public class MarkServiceTest {


    @Autowired
    RestTemplate restTemplate;
    @Test
    void splitText (){
        String text = "财政部 国家税务总局关于增值税几个税收政策问题的通知\n";
        String host = "47.105.158.15";
        String port = "9001";
        String url = "http://" + host + ":" + port + "/split?initialText=" + text;
        List s = restTemplate.getForObject(url, List.class);

        System.out.println(s);
    }

}
