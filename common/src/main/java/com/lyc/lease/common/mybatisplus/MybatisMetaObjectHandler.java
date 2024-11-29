package com.lyc.lease.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: LuKey_C
 * @Description: TODO 实现MetaObjectHandler接口，用于配置MyBatis-Plus的自动填充功能。
 * @Date: 2024/11/29 19:48
 * @Version: 1.0
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在插入操作时自动填充字段。
     * @param metaObject MyBatis的元对象，包含了需要填充的字段信息。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充createTime字段，类型为Date，值为当前时间。
        // 参数说明：
        // - metaObject: MyBatis的元对象，包含了需要填充的字段信息。
        // - "updateTime": 需要填充的字段名。
        // - Date.class: 字段的类型。
        // - new Date(): 填充的值，这里是当前时间。
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    }

    /**
     * 在更新操作时自动填充字段。
     * @param metaObject MyBatis的元对象，包含了需要填充的字段信息。
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填充updateTime字段，类型为Date，值为当前时间。
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}