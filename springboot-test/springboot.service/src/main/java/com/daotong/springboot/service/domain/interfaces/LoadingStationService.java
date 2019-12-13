package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.dto.LoadingStationEnterParam;
import com.daotong.springboot.service.domain.model.LoadingStation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/9 11:35
 */
public interface LoadingStationService {

    /**
     * 站点进站处理
     * @param loadingStation
     */
    @Transactional(rollbackFor = Exception.class)
    void enterStation(LoadingStationEnterParam loadingStation);

    /**
     * 站点出站处理
     * @param loadingStation
     */
    @Transactional(rollbackFor = Exception.class)
    void leaveStation(LoadingStationEnterParam loadingStation);
}
