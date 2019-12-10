package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
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
public class LoadingStationDTO {
    private Integer id;

    private Integer loadingStationId;

    private Integer loadingId;

    private Integer stationId;
    /**
     * 当前站点状态序号
     */
    private Integer seq;
    /**
     * 运单所有的站点序号集合
     */
    private ArrayList<Integer> seqs;

    private LocalDateTime planArrivalTime;

    private LocalDateTime planSendTime;

    private LocalDateTime actualArrivalTime;

    private LocalDateTime actualSendTime;

    private String stationStatus;
}