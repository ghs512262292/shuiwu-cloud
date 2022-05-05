package com.shuiyou.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
//@TableName("clause")
public class Clause {
    @TableId
    private Integer C_id;
    private String type;
    private String mode;
    private String enjoy;
    private String taxType;
    private String policyClassification;
    private String clause_text;
    private Integer N_id;

}
