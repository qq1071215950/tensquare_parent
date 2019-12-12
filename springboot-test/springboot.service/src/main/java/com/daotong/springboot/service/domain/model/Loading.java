package com.daotong.springboot.service.domain.model;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 运单
 *
 * @author Zdh 2019/12/5 15:01
 */
@ApiModel(value = "运单")
@Data
public class Loading {
    private Integer id;
    @ApiModelProperty(value = "运输单号")
    private String loadingNo;
    @ApiModelProperty(value = "首发站点id")
    private Integer sendStationId;
    @ApiModelProperty(value = "末站点id")
    private Integer endStationId;
    @ApiModelProperty(value = "站点名称")
    private String lineName;
    @ApiModelProperty(value = "报价方式")
    private String priceQuote;
    @ApiModelProperty(value = "线路站点数量")
    private Integer stationCount;
    @ApiModelProperty(value = "计划到达首站时间")
    private LocalDateTime planArrivalTime;
    @ApiModelProperty(value = "首站点计划发车时间")
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "计划完成时间")
    private LocalDateTime planCompleteTime;
    @ApiModelProperty(value = "实际到达首站点时间")
    private LocalDateTime actualArrivalTime;
    @ApiModelProperty(value = "首站点实际发车时间")
    private LocalDateTime actualSendTime;
    @ApiModelProperty(value = "实际完成时间")
    private LocalDateTime actualCompleteTime;
    @ApiModelProperty(value = "运单状态")
    private LoadingEnum loadingEnum;
    @ApiModelProperty(value = "商家")
    private String saler;
    @ApiModelProperty(value = "运输商")
    private String forwarder;
    @ApiModelProperty(value = "车牌")
    private String plateNo;
    @ApiModelProperty(value = "温层")
    private String temLayer;
    @ApiModelProperty(value = "司机")
    private String driverName;
    @ApiModelProperty(value = "联系电话")
    private String tel;
    @ApiModelProperty(value = "是否发布")
    private Boolean publish;
}