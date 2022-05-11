package com.web.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Clause_tax {

    @TableId
    private Integer id;
    private Integer clause_id;
    private Integer tax_id;
}
