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
     * 进站出站时更新时间以及站点状态
     *
     * @param loadingStationEnterParam
     */
    @Transactional(rollbackFor = Exception.class)
    void updateStatus(LoadingStationEnterParam loadingStationEnterParam);
}
