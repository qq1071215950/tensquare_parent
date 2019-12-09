package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import com.daotong.springboot.service.domain.model.LoadingStation;
import com.daotong.springboot.service.domain.model.Station;
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
public class LoadingDTO {
    private Integer id;
    private String loadingNo;

    private Integer sendStationId;

    private Integer endStationId;

    private String lineName;

    private Integer stationCount;

    private String priceQuote;

    private LocalDateTime planArrivalTime;

    private LocalDateTime planSendTime;

    private LocalDateTime planComplateTime;

    private LocalDateTime actualArrivalTime;

    private LocalDateTime actualSendTime;

    private LocalDateTime actualComlateTime;

    private LoadingEnum loadingEnum;

    private String saler;

    private String forwarder;

    private String plateNo;

    private String temperatureLayer;

    private String driverName;

    private String tel;
    /**
     * 运单包含的站点
     */
    private List<StationDTO> stations;

}