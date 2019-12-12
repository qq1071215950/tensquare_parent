package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/5 16:12
 */
@Setter
@Getter
@ToString
@ApiModel(value = "运单查询条件封装类",description = "多条件组合查询")
public class LoadingQueryParam {
    @ApiModelProperty(value = "运单id")
    private Integer loadingId;
    @ApiModelProperty(value = "运单号")
    private String loadingNo;
    @ApiModelProperty(value = "首站id")
    private Integer sendStationId;
    @ApiModelProperty(value = "末站id")
    private Integer endStationId;
    @ApiModelProperty(value = "线路名称")
    private String lineName;
    @ApiModelProperty(value = "计划首站发车时间")
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "计划完成时间")
    private LocalDateTime planCompleteTime;
    @ApiModelProperty(value = "运单状态")
    private LoadingEnum loadingEnum;
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
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "分页查询当前页码",notes = "默认查询第一页")
    private Integer curPage = 1;
    /**
     * 每页展示数量
     */
    @ApiModelProperty(value = "分页查询每页展示数量",notes = "默认每页展示10")
    private Integer pageSize = 10;
}