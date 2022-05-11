package com.web.domain;


import lombok.Data;

@Data
public class All_data {

    /**
     * 条款内容
     */
    private String clause_text;
    /**
     * 享受主体
     */
    private String enjoy;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告文号
     */
    private String textID;
    /**
     * 减免方式
     */
    private String mode;
    /**
     * 政策类型
     */
    private String policyClassification;
    /**
     * 减免类型
     */
    private String type;
    /**
     * 涉及税种
     */
    private String taxType;
    /**
     * 时间期限
     */
    private String date;
    /**
     * 公告id
     */
    private Integer N_id;

    /**
     * 条款id
     */
    private Integer C_id;

}
