package com.shuiyou.controller.utils;


import lombok.Data;

/**
 * 定义前后端数据协议保证数据的返回格式相同，方便前端人员操作。
 */


@Data
public class Result {
    private boolean flag;
    // 使用Object就是为了应对各种不同类型的数据
    private Object data;
    // 传递成功或者失败的消息
    private String msg;
}
