package com.web.dao;


import com.web.domain.All_data;
import com.web.domain.Enjoy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EnjoyDaoTest {

    @Autowired
    EnjoyDao enjoyDao;


    @Test
    void getByName() {
        String name = "纳税人";
        List<All_data> all_data = enjoyDao.getByNameToAllData(name);
        System.out.println(all_data);
    }

    @Test
    void selectAll() {
        List<Enjoy> enjoys = enjoyDao.selectList(null);
        for (Enjoy enjoy : enjoys) {
            System.out.println(enjoy);
        }
    }


    @Test
    void getAllData() {
        List<String> allData = enjoyDao.getAllData();
        for (int i = 0; i < 5; i++) {
            System.out.println(allData.get(i));
        }
    }

    @Test
    void selectClauseEnjoy() {
        List<Integer> maps = enjoyDao.getClauseEnjoy(2);
        System.out.println(maps);
    }


}
