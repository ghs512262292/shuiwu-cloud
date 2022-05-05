package com.shuiyou.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuiyou.domain.Enjoy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnjoyDao extends BaseMapper<Enjoy> {


    Enjoy getByName(String name);
    List<Enjoy> getAllData();

    List<Integer> getClauseEnjoy(Integer id);


}
