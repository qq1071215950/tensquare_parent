package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.model.LoadingStation;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 站点信息传输类
 *
 * @author Zdh 2019/12/5 16:03
 */
@Data
@AllArgsConstructor
public class StationDTO {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String provinceCode;

    private String cityName;

    private String cityCode;

    private String areaName;

    private String areaCode;

}