package com.daotong.springboot.service.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Zdh 2019/12/5 16:20
 */
@Getter
@Setter
public class StationQueryResult {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String cityName;

    private String areaName;
}