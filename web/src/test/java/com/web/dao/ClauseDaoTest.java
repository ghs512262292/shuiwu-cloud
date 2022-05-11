package com.web.dao;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.domain.Clause;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClauseDaoTest {


    @Autowired
    ClauseDao clauseDao;


    @Test
    void testSave() {
        Clause clause = new Clause();
        clause.setPolicyClassification("1");
        clause.setEnjoy("1");
        clause.setClause_text("1");
        clause.setMode("1");
        clause.setN_id(1);
        clause.setTaxType("1");
        clause.setType("1");
        clauseDao.insert(clause);
    }

    @Test
    void testDelete() {
        clauseDao.deleteById(1522);
    }

    @Test
    void testSelectAll(){

    }

    @Test
    void testSelectPage() {
        IPage page = new Page(1, 5);
        clauseDao.selectPage(page, null);
    }

}
