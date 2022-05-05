package com.shuiyou.service;


import com.shuiyou.domain.vo.enjoy.EnjoyQueryVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryServiceTest {

    @Autowired
    QueryService queryService;


    @Test
    void selectEnjoy() {
        String name = "幼儿园";
        EnjoyQueryVo enjoyQueryVo = queryService.selectEnjoy(name);
        System.out.println(enjoyQueryVo);
    }
}
