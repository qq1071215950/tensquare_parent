package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/5 16:12
 */
@Setter
@Getter
@ToString
@ApiModel(value = "运单查询条件封装类", description = "多条件组合查询")
public class LoadingQueryParam implements Serializable {

    private Long loadingId;
    @ApiModelProperty(value = "运单号")
    private String loadingNo;
    @ApiModelProperty(value = "首站id")
    private Integer sendStationId;
    @ApiModelProperty(value = "末站id")
    private Integer endStationId;
    @ApiModelProperty(value = "线路名称")
    private String lineName;
    @ApiModelProperty(value = "计划首站发车时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "计划完成时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planCompleteTime;
    @ApiModelProperty(value = "运单状态")
    private String loadingEnum;
    @ApiModelProperty(value = "商家")
    private String saler;
    @ApiModelProperty(value = "运输商")
    private String forwarder;
    @ApiModelProperty(value = "车牌号")
    private String plateNo;
    @ApiModelProperty(value = "温层")
    private String temperatureLayer;
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    @ApiModelProperty(value = "电话")
    private String tel;
}