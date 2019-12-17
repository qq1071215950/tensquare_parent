package com.daotong.springboot.service.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Zdh 2019/12/13 10:23
 */
@Setter
@Getter
@ToString
@ApiModel(value = "新增运单站点信息对象")
public class LoadingStationBO {
    @ApiModelProperty(value = "站点名称",required = true)
    private String stationName;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadingStationBO that = (LoadingStationBO) o;
        return Objects.equals(stationName, that.stationName) &&
                Objects.equals(stationId, that.stationId) &&
                Objects.equals(planArrivalTime, that.planArrivalTime) &&
                Objects.equals(planSendTime, that.planSendTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, stationId, planArrivalTime, planSendTime);
    }
}