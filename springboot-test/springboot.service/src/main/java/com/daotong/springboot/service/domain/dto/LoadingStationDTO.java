package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/6 15:19
 */
@Data
public class LoadingStationDTO {

    private Integer stationId;

    private Integer seq;

    private LocalDateTime planArrivalTime;

    private LocalDateTime planSendTime;

    private LocalDateTime actualArrivalTime;

    private LocalDateTime actualSendTime;

    private String stationStatus;
}