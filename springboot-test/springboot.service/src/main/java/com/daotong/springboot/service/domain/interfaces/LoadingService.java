package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.vo.LoadingVO;
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
    List<LoadingVO> getByQueryParam(LoadingQueryParam loadingQueryParam);

    /**
     * 手动设置完成运单
     *
     * @param loadingId
     * @param completeTime
     */
    void manualComplete(Integer loadingId,LocalDateTime completeTime);

    /**
     * 编辑运单
     *
     * @param loadingDTO
     */
    void updateLoadingMsg(LoadingDTO loadingDTO);
}
