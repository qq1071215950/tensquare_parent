package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.vo.LoadingVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/5 16:46
 */
@Mapper
public interface LoadingMapper {
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
    void manualComplete(@Param(value = "loadingId") Long loadingId, @Param(value = "completeTime") LocalDateTime completeTime);

    /**
     * 更新实际到达首站时间
     *
     * @param loadingId
     * @param actualArrivalTime
     */
    void updateActualArrivalTime(@Param(value = "loadingId") Long loadingId,
                                 @Param(value = "actualArrivalTime") LocalDateTime actualArrivalTime);

    /**
     * 更新实际首站发车时间
     *
     * @param loadingId
     * @param actualSendTime
     */
    void updateActualSendTime(@Param(value = "loadingId") Long loadingId,
                              @Param(value = "actualSendTime") LocalDateTime actualSendTime);

    /**
     * 更新实际完成时间
     *
     * @param loadingId
     * @param actualCompleteTime
     */
    void updateActualCompleteTime(@Param(value = "loadingId") Long loadingId,
                                  @Param(value = "actualCompleteTime") LocalDateTime actualCompleteTime);

    /**
     * 更新运单内容
     *
     * @param loadingDTO
     */
    void updateLoading(LoadingDTO loadingDTO);

    /**
     * 编辑运单为发布状态
     *
     * @param loadingId
     */
    void updatePublish(@Param(value = "loadingId") Long loadingId);
}
