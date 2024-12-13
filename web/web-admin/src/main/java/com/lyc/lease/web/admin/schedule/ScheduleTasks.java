package com.lyc.lease.web.admin.schedule;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.lyc.lease.model.entity.LeaseAgreement;
import com.lyc.lease.model.enums.LeaseStatus;
import com.lyc.lease.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: LuKey_C
 * @Description: TODO 定时类
 * @Date: 2024/12/13 17:02
 * @Version: 1.0
 */

@Component
public class ScheduleTasks {
//            ┌───────────── second (0-59)
//            │ ┌───────────── minute (0 - 59)
//            │ │ ┌───────────── hour (0 - 23)
//            │ │ │ ┌───────────── day of the month (1 - 31)
//            │ │ │ │ ┌───────────── month (1 - 12) (or JAN-DEC)
//            │ │ │ │ │ ┌───────────── day of the week (0 - 7)
//            │ │ │ │ │ │          (0 or 7 is Sunday, or MON-SUN)
//            │ │ │ │ │ │
//            * * * * * *
//    @Scheduled(cron = "* * * * * *")
//    public void test(){
//        System.out.println(new Date());
//    }
    @Autowired
    private LeaseAgreementService service;

    /**
     * 定时任务：检查租赁协议状态
     * 每天午夜（00:00）执行一次，更新所有到期的租赁协议状态为已过期。
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void checkLeaseStatus(){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(LeaseAgreement::getLeaseEndDate,new Date());
        updateWrapper.in(LeaseAgreement::getStatus,LeaseStatus.SIGNED,LeaseStatus.WITHDRAWING);
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        service.update(updateWrapper);
    }
}
