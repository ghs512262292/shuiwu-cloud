package com.shuiyou.domain.vo.enjoy;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnjoyQueryVo {
    private List<EnjoyQueryDataVo> standardData = new ArrayList<>();
    private List<EnjoyQueryDataVo> similarData = new ArrayList<>();
}
