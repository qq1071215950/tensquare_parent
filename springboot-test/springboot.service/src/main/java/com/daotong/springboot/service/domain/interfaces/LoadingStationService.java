package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.model.LoadingStation;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/9 11:35
 */
public interface LoadingStationService {

    /**
     * 更新运单站点状态
     * @param loadingStationStatus
     * @param loadingId
     * @param stationId
     * @param time
     * @return
     */
    int updateLoadingStationStatus(String loadingStationStatus,LocalDateTime time,  Integer loadingId, Integer stationId);

}
