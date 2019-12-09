package com.daotong.springboot.service.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/6 15:38
 */
@Data
public class LoadingQueryResult {
    private Integer id;
    private String loadingNo;
   /* private String destination=this.stations.get(this.stations.size()-1).getName();
    private LocalDateTime planSendTime=this.stations.get(0).getLoadingStation().getPlanSendTime();
    private LocalDateTime planArrivedTime=this.stations.get(this.stations.size()-1).getLoadingStation().getPlanArrivalTime();*/
    private String destination;
    private LocalDateTime planSendTime;
    private LocalDateTime planArrivedTime;
    private String forwarder;
    private String temperatureLayer;
    private List<StationDTO> stations;
}