package com.daotong.springboot.service.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Zdh 2019/12/5 16:10
 */
@Setter
@Getter
public class StationQueryParam {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String cityName;

    private String areaName;

}