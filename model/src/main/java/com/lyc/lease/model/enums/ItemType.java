package com.lyc.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


public enum ItemType implements BaseEnum {

    APARTMENT(1, "公寓"),

    ROOM(2, "房间");


    @EnumValue //在使用MyBatis Plus进行数据库操作时，@EnumValue会确保code字段被正确映射到数据库列。
    @JsonValue //在使用Jackson进行JSON序列化时，@JsonValue会确保枚举对象被序列化为其code值。
    private Integer code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getName() {
        return name;
    }

    ItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
