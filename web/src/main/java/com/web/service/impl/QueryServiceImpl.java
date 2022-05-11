package com.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feignApi.clients.PythonClient;
import com.web.dao.All_dataDao;
import com.web.dao.EnjoyDao;
import com.web.domain.Clause;
import com.web.domain.vo.enjoy.EnjoyQueryDataVo;
import com.web.domain.vo.enjoy.EnjoyQueryVo;
import com.web.dao.ClauseDao;
import com.web.domain.All_data;
import com.web.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    ClauseDao clauseDao;
    @Autowired
    All_dataDao all_dataDao;

    @Autowired
    EnjoyDao enjoyDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    PythonClient pythonClient;

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
        // 1.首先为了获取相似的享受主体，因此要获取数据库中所有的享受主体的信息,使用了redis缓存
        Set<String> allData = getEnjoyAllData();

        // 2.计算当前传入的享受主体的相似享受主体，这里主要是利用了RPC调用python算法
        Map<String, Object> map = new HashMap<>();
        map.put("enjoyList", allData);
        map.put("enjoy", name);
        List<String> similarList = pythonClient.getSimilar(map);


        // 5.首先构造当前享受主体的数据(并判断当前的输入是否存在)
            // 创建一个最终返回的容器
        EnjoyQueryVo enjoyQueryVo = new EnjoyQueryVo();

            // 当前享受主体数据构造
        mainEnjoyDataProcess(name, enjoyQueryVo);

        // 6.构造相似享受主体数据
        for (String similarEnjoy : similarList) {
            similarEnjoyDataProcess(similarEnjoy, enjoyQueryVo);
        }

        return enjoyQueryVo;

    }

    public Set<String> getEnjoyAllData() {
        String enjoyAllData = "enjoyAllData";
        SetOperations<String, String> ops = stringRedisTemplate.opsForSet();
        Set<String> data = ops.members(enjoyAllData);
        return data;
    }


    public void mainEnjoyDataProcess(String name, EnjoyQueryVo enjoyQueryVo) {
        List<All_data> all_data = enjoyDao.getByNameToAllData(name);
            // 获取当前享受主体所对应的clauseID(条款ID)
        if (all_data == null) {
            enjoyQueryVo.setStandardData(null);
            return;
        }
        for (All_data data : all_data) {
            EnjoyQueryDataVo enjoyQueryDataVo = new EnjoyQueryDataVo();
            enjoyQueryDataVo.setEnjoy(data.getEnjoy());
            enjoyQueryDataVo.setData(data);
            enjoyQueryDataVo.setTaxType(data.getTaxType());
            enjoyQueryVo.getStandardData().add(enjoyQueryDataVo);
        }

    }
    public void similarEnjoyDataProcess(String name, EnjoyQueryVo enjoyQueryVo) {
        List<All_data> all_data = enjoyDao.getByNameToAllData(name);
        // 获取当前享受主体所对应的clauseID(条款ID)
        for (All_data data : all_data) {
            EnjoyQueryDataVo enjoyQueryDataVo = new EnjoyQueryDataVo();
            enjoyQueryDataVo.setEnjoy(data.getEnjoy());
            enjoyQueryDataVo.setData(data);
            enjoyQueryDataVo.setTaxType(data.getTaxType());
            enjoyQueryVo.getSimilarData().add(enjoyQueryDataVo);
        }

    }


}
