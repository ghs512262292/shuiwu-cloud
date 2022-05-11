package com.web.dao;


import com.web.domain.All_data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class All_dataDaoTest {

    @Autowired
    All_dataDao all_dataDao;

    @Test
    void selectAll() {
        int page = 5;
        int size = 10;
        page = (page - 1) * size;
        List<All_data> all_data = all_dataDao.selectAll(page, size);
        System.out.println(all_data.get(0));
    }
}
