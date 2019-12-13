package com.daotong.springboot.service.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/13 10:23
 */
@Data
@ApiModel(value = "新增运单站点信息对象")
public class LoadingStationBO {
    @ApiModelProperty(value = "站点名称",required = true)
    private String stationName;
    @ApiModelProperty(value = "站点状态信息id",required = true)
    private Integer id;
    @ApiModelProperty(value = "运单id",required = true)
    private Long loadingId;
    @ApiModelProperty(value = "站点id",required = true)
    private Integer stationId;
    @ApiModelProperty(value = "站点序号",required = true)
    private Integer seq;
    @ApiModelProperty(value = "计划站点到达时间",required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planArrivalTime;
    @ApiModelProperty(value = "计划站点发车时间",required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planSendTime;
    @ApiModelProperty(value = "站点状态")
    private String stationStatus;
}