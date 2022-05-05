package com.shuiyou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shuiyou.controller.utils.MySimHash;
import com.shuiyou.dao.All_dataDao;
import com.shuiyou.dao.ClauseDao;
import com.shuiyou.dao.EnjoyDao;
import com.shuiyou.domain.All_data;
import com.shuiyou.domain.Clause;
import com.shuiyou.domain.Enjoy;
import com.shuiyou.domain.vo.enjoy.EnjoyQueryDataVo;
import com.shuiyou.domain.vo.enjoy.EnjoyQueryVo;
import com.shuiyou.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    ClauseDao clauseDao;
    @Autowired
    All_dataDao all_dataDao;

    @Autowired
    EnjoyDao enjoyDao;

    @Override
    public List<All_data> selectPageAll(int currPage, int size) {
        // 数据库分页公式
        currPage = (currPage - 1) * size;
        List<All_data> all_data = all_dataDao.selectAll(currPage, size);
        return all_data;
    }


    @Override
    public IPage selectPageAll(int currPage, int size, Clause clause) {
        IPage<Clause> page = new Page<>(currPage, size);

        // 定义条件对象
        LambdaQueryWrapper qw = new LambdaQueryWrapper();

        // toDo 目前的showData数据不完全，还要进行Notice表的联查，之后进行补充
        // 在分页查询中加入条件对象
        clauseDao.selectPage(page, qw);
        return page;
    }

    @Override
    public EnjoyQueryVo selectEnjoy(String name) {
        // 1.首先为了获取相似的享受主体，因此要获取数据库中所有的享受主体的信息
        List<Enjoy> allData = enjoyDao.getAllData();

        // 2.计算当前传入的享受主体的simHash
        String curEnjoy = name;
        MySimHash curEnjoyHash = new MySimHash(curEnjoy);
        // 3.建立相似享受主体列表，以便把判断的相似的享受主体保存起来
        List<Enjoy> similarList = new ArrayList<>();

        // 4.遍历判断所有的享受主体的simHash值，判断是否加入到相似的享受主体列表中
        for (Enjoy enjoy : allData) {
            String similarName = enjoy.getName();
            // 过去标准享受主体
            if (similarName.equals(name)) {
                continue;
            }
            MySimHash similarEnjoyHash = new MySimHash(similarName);
            if (curEnjoyHash.getSemblance(similarEnjoyHash) <= 0.33) {
                similarList.add(enjoy);
            }
        }

        // 5.首先构造当前享受主体的数据(并判断当前的输入是否存在)
            // 创建一个最终返回的容器
        EnjoyQueryVo enjoyQueryVo = new EnjoyQueryVo();

            // 当前享受主体数据构造
        mainEnjoyDataProcess(name, enjoyQueryVo);

        // 6.构造相似享受主体数据
        for (Enjoy similarEnjoy : similarList) {
            similarEnjoyDataProcess(similarEnjoy.getName(), enjoyQueryVo);
        }

        return enjoyQueryVo;

    }




    public void mainEnjoyDataProcess(String name, EnjoyQueryVo enjoyQueryVo) {
        Enjoy enjoy = enjoyDao.getByName(name);
            // 获取当前享受主体所对应的clauseID(条款ID)
        if (enjoy == null) {
            enjoyQueryVo.setStandardData(null);
            return;
        }
        List<Integer> clauseList = enjoyDao.getClauseEnjoy(enjoy.getId());
        for (Integer i : clauseList) {
            All_data enjoyData = all_dataDao.selectAllByC_id(i);
            EnjoyQueryDataVo enjoyQueryDataVo = new EnjoyQueryDataVo();
            enjoyQueryDataVo.setEnjoy(enjoyData.getEnjoy());
            enjoyQueryDataVo.setData(enjoyData);
            enjoyQueryDataVo.setTaxType(enjoyData.getTaxType());
            enjoyQueryVo.getStandardData().add(enjoyQueryDataVo);
        }
    }
    public void similarEnjoyDataProcess(String name, EnjoyQueryVo enjoyQueryVo) {
        Enjoy enjoy = enjoyDao.getByName(name);
            // 获取当前享受主体所对应的clauseID(条款ID)
        List<Integer> clauseList = enjoyDao.getClauseEnjoy(enjoy.getId());
        for (Integer i : clauseList) {
            All_data enjoyData = all_dataDao.selectAllByC_id(i);
            EnjoyQueryDataVo enjoyQueryDataVo = new EnjoyQueryDataVo();
            enjoyQueryDataVo.setEnjoy(enjoyData.getEnjoy());
            enjoyQueryDataVo.setData(enjoyData);
            enjoyQueryDataVo.setTaxType(enjoyData.getTaxType());
            enjoyQueryVo.getSimilarData().add(enjoyQueryDataVo);
        }
    }


}
