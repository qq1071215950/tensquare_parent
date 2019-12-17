package com.daotong.springboot.service.config;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * @author Zdh 2019/12/16 11:36
 */
@Slf4j
public class LoadingEnumConverter implements Converter<String, LoadingEnum> {
    @Override
    public LoadingEnum convert(String source) {
        if (StringUtils.isEmpty(source)){
            return null;
        }
        try {
            LoadingEnum loadingEnum = LoadingEnum.valueOf(source);
            return loadingEnum;
        } catch (IllegalArgumentException e) {
            log.error("类型转换错误");
            return null;
        }
    }
}