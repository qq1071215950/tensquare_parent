package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/6 15:34
 */
@Transactional(rollbackFor = Exception.class)
public interface LoadingService {
    /**
     * 创建订单
     *
     * @param loading
     * @return
     */
    int saveLoading(LoadingDTO loading);
    /**
     * 根据条件组合查询运单
     *
     * @param loadingQueryParam
     * @return
     */
    List<LoadingDTO> getByQueryParam(LoadingQueryParam loadingQueryParam);

    /**
     * 手动设置完成运单
     *
     * @param loadingId
     * @param complateTime
     */
    void manualComplete(Integer loadingId,LocalDateTime complateTime);

}
