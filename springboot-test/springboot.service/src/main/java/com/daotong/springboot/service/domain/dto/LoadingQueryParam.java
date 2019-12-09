package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.enums.LoadingEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/5 16:12
 */
@Setter
@Getter
public class LoadingQueryParam {

    private String loadingNo;

    private Integer sendStationId;

    private Integer endStationId;

    private String lineName;

    private LocalDateTime planSendTime;

    private LocalDateTime planComplateTime;

    private LoadingEnum loadingEnum;

    private String saler;

    private String forwarder;

    private String plateNo;

    private String temperatureLayer;

    private String driverName;

    private String tel;
    /**
     * 当前页码
     */
    private Integer curPage;
    /**
     * 每页展示数量
     */
    private Integer pageSize;
}