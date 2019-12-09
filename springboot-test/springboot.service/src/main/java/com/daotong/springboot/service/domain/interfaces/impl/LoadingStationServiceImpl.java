package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.interfaces.LoadingStationService;
import com.daotong.springboot.service.domain.model.LoadingStation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/9 11:40
 */
@Service
public class LoadingStationServiceImpl implements LoadingStationService {

    @Override
    public int updateLoadingStationStatus(String loadingStationStatus,LocalDateTime time,  Integer loadingId, Integer stationId) {
        return 0;
    }
}