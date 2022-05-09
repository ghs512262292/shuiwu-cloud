package com.shuiyou.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shuiyou.domain.All_data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface All_dataDao extends BaseMapper<All_data> {

    @Select("SELECT * " +
            " FROM clause, notice " +
            " WHERE clause.N_id = notice.N_id"+
            " LIMIT #{page}, #{size}")
    List<All_data> selectAll(Integer page, Integer size);

    @Select("SELECT *" +
            " FROM clause c, notice n" +
            " WHERE c.C_id = #{id} and c.N_id = n.N_id")
    All_data selectAllByC_id(Integer id);

}
