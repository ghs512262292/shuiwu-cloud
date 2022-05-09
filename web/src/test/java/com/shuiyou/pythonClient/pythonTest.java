package com.shuiyou.pythonClient;

import com.shuiyou.clients.PythonClient;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class pythonTest {

    @Autowired
    PythonClient pythonClient;

    @Test
    void  test() {
        Set<String> allData = new HashSet<>();
        allData.add("111");
        allData.add("222");
        String name = "333";
        Map<String, Object> map = new HashMap<>();
        map.put("enjoyList", allData);
        map.put("enjoy", name);

        List<String> similarList = pythonClient.getSimilar(map);
    }

}
