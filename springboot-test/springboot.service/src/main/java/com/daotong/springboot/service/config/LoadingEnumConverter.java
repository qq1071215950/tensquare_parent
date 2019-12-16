package com.daotong.springboot.service.config;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Zdh 2019/12/16 11:36
 */
public class LoadingEnumConverter implements Converter<String, LoadingEnum> {
    @Override
    public LoadingEnum convert(String source) {
        return LoadingEnum.valueOf(source);
    }
}