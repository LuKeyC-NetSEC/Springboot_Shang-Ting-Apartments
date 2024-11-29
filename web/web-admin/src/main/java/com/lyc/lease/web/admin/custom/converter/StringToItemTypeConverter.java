package com.lyc.lease.web.admin.custom.converter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.lyc.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Author: LuKey_C
 * @Description: TODO 字符串到ItemType的转换器，用于将请求参数中的字符串转换为ItemType枚举类型。
 * @Date: 2024/11/29 20:41
 * @Version: 1.0
 */

@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {

    /**
     * 将字符串转换为ItemType枚举。
     *
     * @param code 字符串形式的代码，表示ItemType的类型。
     * @return 对应的ItemType枚举值。
     * @throws IllegalArgumentException 如果code不合法，抛出异常。
     */
    @Override
    public ItemType convert(String code) {
        for (ItemType value : ItemType.values()) {
            if (value.getCode().equals(Integer.valueOf(code))){
                return value;
            }
        }
        throw new IllegalArgumentException("code:"+code+"非法");
    }
}
