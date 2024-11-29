package com.lyc.lease.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT) // 添加填充时机 当插入数据时触发
    @JsonIgnore // 禁用该属性序列化
    private Date createTime;

    @Schema(description = "更新时间")
    @TableField(value = "update_time",fill = FieldFill.UPDATE) // 添加填充时机 当更新数据时触发
    @JsonIgnore // 禁用该属性序列化
    private Date updateTime;

    @Schema(description = "逻辑删除")
    @TableField("is_deleted")
    @JsonIgnore // 禁用该属性序列化
    @TableLogic // 该属性用于逻辑删除 仅在MP库框架中SQL生效
    private Byte isDeleted;

}