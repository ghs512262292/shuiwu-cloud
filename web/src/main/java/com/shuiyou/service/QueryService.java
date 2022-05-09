package com.shuiyou.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.shuiyou.domain.All_data;
import com.shuiyou.domain.Clause;
import com.shuiyou.domain.Enjoy;
import com.shuiyou.domain.vo.enjoy.EnjoyQueryVo;

import java.util.List;
import java.util.Set;

public interface QueryService {

    /**
     * 普通全览查询
     * @param currPage 当前页码数
     * @param size 每页显示的数据数量
     * @return
     */
    List<All_data> selectPageAll(int currPage, int size);



    /**
     * 条件全览查询（公告名称，问号，期限大小排列）
     * @param currPage
     * @param size
     * @return
     */
    IPage selectPageAll(int currPage, int size, Clause clause);

    EnjoyQueryVo selectEnjoy(String name);


}
