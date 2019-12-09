package com.daotong.springboot.service.domain.model;

import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 运单站点
 *
 * @author Zdh 2019/12/5 14:25
 */
@ApiModel(value = "运单站点")
@Data
public class LoadingStation {
    private Integer id;
    @ApiModelProperty(value = "运单号")
    private String loadingNo;
    @ApiModelProperty(value = "站点id")
    private Integer stationId;
    @ApiModelProperty(value = "序号")
    private Integer seq;
    @ApiModelProperty(value = "计划到达时间")
    private LocalDateTime planArrivalTime;
    @ApiModelProperty(value = "计划发车时间")
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "实际到达时间")
    private LocalDateTime actualArrivalTime;
    @ApiModelProperty(value = "实际发车时间")
    private LocalDateTime actualSendTime;
    @ApiModelProperty(value = "站点状态")
    private LoadingStationEnum loadingStationEnum;

}