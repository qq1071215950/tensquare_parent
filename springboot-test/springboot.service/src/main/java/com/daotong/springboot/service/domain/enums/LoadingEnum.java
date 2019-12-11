package com.daotong.springboot.service.domain.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运单状态枚举类
 *
 * @author Zdh 2019年12月5日14:36:55
 */
@ApiModel(value = "运单状态枚举类")
public enum LoadingEnum {
    //初始化
    ARRIVAL("initialize"),
    //到达首发
    AT_START("arrivedStart"),
    //在途
    TRANSPORTING("transporting"),
    //完成
    COMPLETE("complete"),
    //手动完成
    MANUALLY("manual");

    @ApiModelProperty(value = "运单状态")
    private String loadingStatus;

    LoadingEnum(String loadingStatus) {
        this.loadingStatus = loadingStatus;
    }

    public String getLoadingStatus() {
        return loadingStatus;
    }
}
