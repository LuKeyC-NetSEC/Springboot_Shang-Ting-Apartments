package com.lyc.lease.web.admin.custom.config;

import com.lyc.lease.web.admin.custom.converter.StringToItemTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LuKey_C
 * @Description: TODO 添加自定义Converter
 * @Date: 2024/11/29 20:56
 * @Version: 1.0
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private StringToItemTypeConverter stringToItemTypeConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToItemTypeConverter);
    }
}
