package com.shuiyou.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuiyou.domain.All_data;
import com.shuiyou.domain.Enjoy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnjoyDao extends BaseMapper<Enjoy> {


//    Enjoy getByName(String name);
    List<String> getAllData();

    List<Integer> getClauseEnjoy(Integer id);

    List<All_data> getByNameToAllData(String name);

}
