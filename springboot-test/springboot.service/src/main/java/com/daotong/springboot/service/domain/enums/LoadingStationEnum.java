package com.daotong.springboot.service.domain.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运单站点状态
 *
 * @author Zdh 2019/12/5 14:55
 */
@ApiModel(value = "运单站点状态枚举类")
public enum LoadingStationEnum {
    //未发车
    UN_START("beforeStart"),
    //到达
    ARRIVAL("arrived"),
    //出发
    START("start");
    @ApiModelProperty(value = "站点状态")
    private String status;

    LoadingStationEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}