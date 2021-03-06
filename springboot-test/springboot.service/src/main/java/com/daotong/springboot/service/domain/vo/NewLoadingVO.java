package com.daotong.springboot.service.domain.vo;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/11 14:53
 */
@Setter
@Getter
@ToString
public class NewLoadingVO {

    private String loadingNo;

    private Long loadingId;

    private Integer sendStationId;

    private Integer endStationId;

    private String lineName;

    private Integer stationCount;

    private String priceQuote;

    private LocalDateTime planArrivalTime;

    private LocalDateTime planSendTime;

    private LocalDateTime planCompleteTime;

    private LocalDateTime actualArrivalTime;

    private LocalDateTime actualSendTime;

    private LocalDateTime actualCompleteTime;

    private String loadingStatus;

    private String saler;

    private String forwarder;

    private String plateNo;

    private String temperatureLayer;

    private String driverName;

    private String tel;

    private boolean publish;

    private List<LoadingStationDTO> stations;
}