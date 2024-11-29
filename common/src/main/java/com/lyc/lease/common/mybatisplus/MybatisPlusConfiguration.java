package com.lyc.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: LuKey_C
 * @Description: TODO
 * @Date: 2024/11/29 17:28
 * @Version: 1.0
 */

@Configuration
@MapperScan("com.lyc.lease.web.*.mapper")
public class MybatisPlusConfiguration {

}