package com.daotong.springboot.service.domain.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 站点信息
 *
 * @author Zdh 2019/12/5 14:18
 */
@Data
@ApiModel(value = "站点")
public class Station {
    private Integer id;
    @ApiModelProperty(value = "编码")
    private String code;
    @ApiModelProperty(value = "站点名称")
    private String name;
    @ApiModelProperty(value = "省")
    private String provinceName;
    @ApiModelProperty(value = "省")
    private String provinceCode;
    @ApiModelProperty(value = "市")
    private String cityName;
    @ApiModelProperty(value = "市")
    private String cityCode;
    @ApiModelProperty(value = "区")
    private String areaName;
    @ApiModelProperty(value = "区")
    private String areaCode;
}