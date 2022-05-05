package com.shuiyou.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Notice {

    @TableId
    private Integer N_id;
    private String textID;
    private String title;
    private String notice_text;
    private String date;
    private String save_time;
}
