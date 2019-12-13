package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.dto.LoadingStationEnterOrLeaveParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zdh 2019/12/9 11:35
 */
public interface LoadingStationService {

    /**
     * 站点进站处理
     * @param loadingStation
     */
    @Transactional(rollbackFor = Exception.class)
    void enterStation(LoadingStationEnterOrLeaveParam loadingStation);

    /**
     * 站点出站处理
     * @param loadingStation
     */
    @Transactional(rollbackFor = Exception.class)
    void leaveStation(LoadingStationEnterOrLeaveParam loadingStation);
}
