package com.lyc.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: LuKey_C
 * @Description: TODO
 * @Date: 2024/11/29 17:17
 * @Version: 1.0
 */

@EnableScheduling //开启定时任务
@SpringBootApplication
public class AdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class,args);
    }
}
