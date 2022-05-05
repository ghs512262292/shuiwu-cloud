package com.shuiyou.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常信息,到这个方法
    @ExceptionHandler
    public Result doException(Exception ex) {
        // 记录日志
        // 通知运维
        // 通知开发

        // 打印异常信息，开发者检查来用,防止异常被"吞"掉
        ex.printStackTrace();
        Result result = new Result();
        result.setFlag(false);
        result.setMsg("服务器故障，请稍后再试");
        return result;
    }


    /**
     * 这里可以对不同的异常进行处理，在注解后面加上字段来进行不同类型的异常
     */
//    @ExceptionHandler(Exception.class)
//    public Result doException(Exception ex) {
//        ex.printStackTrace();
//        Result result = new Result();
//        result.setFlag(false);
//        result.setMsg("服务器故障，请稍后再试");
//        return result;
//    }
}
