package com.lyc.lease.web.admin.custom.config;

import com.lyc.lease.web.admin.custom.converter.StringToBaseConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LuKey_C
 * @Description: TODO 配置自定义的Converter以解决HTTP请求参数到Enum类型的转换问题。
 *                    通过添加自定义的ConverterFactory来支持通用的字符串到枚举类型的转换。
 * @Date: 2024/11/29 20:56
 * @Version: 1.0
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//    @Autowired 过时的
//    private StringToItemTypeConverter stringToItemTypeConverter;

    @Autowired
    private StringToBaseConverterFactory stringToBaseConverterFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(stringToItemTypeConverter);
        registry.addConverterFactory(stringToBaseConverterFactory);
    }
}
