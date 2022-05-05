package com.shuiyou.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Enjoy {

    @TableId
    private Integer id;
    private String name;

}
