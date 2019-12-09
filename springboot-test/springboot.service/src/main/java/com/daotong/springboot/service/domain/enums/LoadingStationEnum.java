package com.daotong.springboot.service.domain.enums;

import io.swagger.annotations.ApiModel;

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
    private String status;

    LoadingStationEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}