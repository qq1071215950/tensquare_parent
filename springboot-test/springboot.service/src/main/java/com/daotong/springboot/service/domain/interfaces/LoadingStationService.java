package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.model.LoadingStation;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/9 11:35
 */
public interface LoadingStationService {

    /**
     * 进站出站时更新时间以及站点状态
     *
     * @param loadingStationId
     * @param currentTime
     * @param seq
     */
    void updateStatus(Integer loadingStationId, LocalDateTime currentTime, Integer seq);
}