package com.daotong.springboot.service.domain.bo;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/13 10:26
 */
@Data
@ApiModel(value = "创建订单对象")
public class LoadingBO {
    @ApiModelProperty(value = "首发站ID",required = true)
    private Integer sendStationId;
    @ApiModelProperty(value = "末站ID",required = true)
    private Integer endStationId;
    @ApiModelProperty(value = "线路名称",required = true)
    private String lineName;
    @ApiModelProperty(value = "路线站点数量",required = true)
    private Integer stationCount;
    @ApiModelProperty(value = "报价方式")
    private String priceQuote;
    @ApiModelProperty(value = "计划运单完成时间",required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planCompleteTime;
    @ApiModelProperty(value = "运单状态")
    private String loadingStatus;
    @ApiModelProperty(value = "商家")
    private String saler;
    @ApiModelProperty(value = "运输商")
    private String forwarder;
    @ApiModelProperty(value = "车牌")
    private String plateNo;
    @ApiModelProperty(value = "温层")
    private String temperatureLayer;
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    @ApiModelProperty(value = "联系方式")
    private String tel;
    @ApiModelProperty(value = "是否发布")
    private Boolean publish;
    @ApiModelProperty(value = "运单站点信息",required = true)
    private List<LoadingStationBO> stations;
}