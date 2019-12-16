package com.daotong.springboot.service.config;

import ch.qos.logback.classic.pattern.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zdh 2019/12/10 17:48
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 添加转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LoadingEnumConverter());
        registry.addConverter(new StringToDateTimeConverter());
    }
}