package com.lyc.lease.common.exception;

import com.lyc.lease.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @Author: LuKey_C
 * @Description: TODO 自定义异常类 封装运行时异常
 * @Date: 2024/12/5 11:09
 * @Version: 1.0
 */

@Data
public class LeaseException extends RuntimeException{

    private Integer code;

    public LeaseException(Integer code,String message){
        super(message);
        this.code = code;
    }
    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
