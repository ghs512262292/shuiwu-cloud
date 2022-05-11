package com.web.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Big_tax {

    @TableId
    private Integer T_di;
    private String name;
}
