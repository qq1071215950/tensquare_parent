package com.daotong.springboot.service.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 更新站点信息前端页面传入的参数对象
 */
@Data
@ApiModel(value = "更新站点信息对象")
public class UpdateStationBO {
    @ApiModelProperty(value = "站点id")
    private Integer id;
    @ApiModelProperty(value = "站点编码")
    private String code;
    @ApiModelProperty(value = "站点名称")
    private String name;
    @ApiModelProperty(value = "省编码")
    private String provinceCode;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "城市编码")
    private String cityCode;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "区编码")
    private String areaCode;
    @ApiModelProperty(value = "区名称")
    private String areaName;
}
