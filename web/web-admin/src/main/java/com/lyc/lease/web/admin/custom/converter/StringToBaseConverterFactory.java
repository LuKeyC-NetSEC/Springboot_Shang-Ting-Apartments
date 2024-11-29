package com.lyc.lease.web.admin.custom.converter;

import com.lyc.lease.model.enums.BaseEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: LuKey_C
 * @Description: TODO 通用的字符串到枚举类型转换器工厂，
 *                    用于将请求参数中的字符串转换为实现了BaseEnum接口的枚举类型
 * @Date: 2024/11/29 22:11
 * @Version: 1.0
 */

@Component
public class StringToBaseConverterFactory implements ConverterFactory<String, BaseEnum> {

    /**
     * 获取字符串到指定枚举类型的转换器。
     *
     * @param targetType 目标枚举类型，必须实现BaseEnum接口。
     * @return 字符串到目标枚举类型的转换器。
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            /**
             * 将字符串转换为目标枚举类型的实例。
             *
             * @param code 字符串形式的代码，表示枚举的类型。
             * @return 对应的枚举实例。
             * @throws IllegalArgumentException 如果code不合法，抛出异常。
             */
            @Override
            public T convert(String code) {
                for (T constant : targetType.getEnumConstants()) {
                    if (constant.getCode().equals(Integer.valueOf(code))){
                        return constant;
                    }
                }
                throw new IllegalArgumentException("code:"+code+"非法");
            }
        };
    }
}
