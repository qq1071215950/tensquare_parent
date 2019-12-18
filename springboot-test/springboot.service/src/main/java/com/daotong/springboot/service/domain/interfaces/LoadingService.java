package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.bo.LoadingBO;
import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.vo.LoadingVO;
import com.daotong.springboot.service.domain.vo.NewLoadingVO;
import org.springframework.transaction.annotation.Transactional;

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
    int saveLoading(LoadingBO loading);
    /**
     * 根据条件组合查询运单
     *
     * @param loadingQueryParam
     * @return
     */
    List<NewLoadingVO> getByQueryParam(LoadingQueryParam loadingQueryParam);

    /**
     * 手动设置完成运单
     *  @param loadingId
     *
     */
    void manualComplete(Long loadingId);

    /**
     * 编辑运单
     *
     * @param loadingDTO
     */
    void updateLoadingMsg(LoadingDTO loadingDTO);

    /**
     * 批量编辑运单状态为发布
     * @param loadingIds
     */
    void publish(Long[] loadingIds);

}
