package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import com.daotong.springboot.service.domain.model.LoadingStation;
import com.daotong.springboot.service.domain.model.Station;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 运单信息传输类
 *
 * @author Zdh 2019/12/5 16:07
 */
@Data
@ApiModel(value = "运单信息传输类")
public class LoadingDTO {
    @ApiModelProperty(value = "运单号",dataType = "string")
    private String loadingNo;
    @ApiModelProperty(value = "运单id",notes = "进出站时必须有该参数")
    private Integer loadingId;
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
    @ApiModelProperty(value = "计划首站到达时间",required = true)
    private LocalDateTime planArrivalTime;
    @ApiModelProperty(value = "计划首站出发时间",required = true)
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "计划运单完成时间",required = true)
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
    /**
     * 运单包含的站点状态
     */
    @ApiModelProperty(value = "运单站点信息")
    private List<LoadingStationDTO> stations;

}