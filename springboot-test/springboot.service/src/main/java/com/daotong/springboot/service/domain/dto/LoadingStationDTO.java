package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Zdh 2019/12/6 15:19
 */
@Data
@ApiModel(value = "运单站点控制层参数封装类")
public class LoadingStationDTO {
    @ApiModelProperty(value = "站点名称",required = true)
    private String stationName;
    @ApiModelProperty(value = "站点状态信息id",required = true)
    private Integer id;
    @ApiModelProperty(value = "运单id",required = true)
    private Integer loadingId;
    @ApiModelProperty(value = "站点id",required = true)
    private Integer stationId;
    @ApiModelProperty(value = "站点序号",required = true)
    private Integer seq;
    @ApiModelProperty(value = "计划站点到达时间",required = true)
    private LocalDateTime planArrivalTime;
    @ApiModelProperty(value = "计划站点发车时间",required = true)
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "站点实际到达时间")
    private LocalDateTime actualArrivalTime;
    @ApiModelProperty(value = "站点实际发车时间")
    private LocalDateTime actualSendTime;
    @ApiModelProperty(value = "站点状态")
    private String stationStatus;
}