package com.daotong.springboot.service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Zdh 2019/12/10 17:43
 */
@Configuration
@Slf4j
public class StringToDateTimeConverter implements Converter<String,LocalDateTime>{
    /**
     * 字符串转换LocalDateTime类型转换器
     * @param s
     * @return
     */
    @Override
    public LocalDateTime convert(String s) {
        if (s==null || "".equals(s)){
            return null;
        }
        try {
            LocalDate parse = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyyMMdd"));
            return parse.atStartOfDay();
        }catch (RuntimeException e){
            log.error("参数转换Date异常："+ e.getMessage());
        }
        try {
            return LocalDateTime.parse(s,DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        }catch (RuntimeException e){
            log.error("参数转换DateTime异常"+ e.getMessage());
            throw new RuntimeException("在Controller转换日期格式时发生错误");
        }
    }
}