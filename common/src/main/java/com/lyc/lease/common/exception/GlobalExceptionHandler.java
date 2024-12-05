package com.lyc.lease.common.exception;

import com.lyc.lease.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LuKey_C
 * @Description: TODO 全局异常处理器
 * @Date: 2024/11/30 17:16
 * @Version: 1.0
 */
@ControllerAdvice // 用于处理Controller层方法的异常
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.getMessage();
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(LeaseException.class)
    @ResponseBody
    public Result error(LeaseException e){
        return Result.fail(e.getCode(), e.getMessage());
    }

}
