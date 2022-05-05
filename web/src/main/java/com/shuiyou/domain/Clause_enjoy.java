package com.shuiyou.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Clause_enjoy {

    @TableId
    private Integer id;
    private String start_end;
    private String enjoy_id;
    private String clause_id;
}
