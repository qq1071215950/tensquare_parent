package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
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
    Page<LoadingDTO> getByQueryParam(LoadingQueryParam loadingQueryParam);

    /**
     * 手动设置完成运单
     *
     * @param loadingId
     * @param complateTime
     */
    void manualComplete(@Param(value = "loadingId") Integer loadingId, @Param(value = "complateTime") LocalDateTime complateTime);

    /**
     * 更新实际到达首站时间
     *
     * @param loadingId
     * @param actualArrivalTime
     */
    void updateActualArrivalTime(@Param(value = "loadingId") Integer loadingId,
                                 @Param(value = "ActualArrivalTime") LocalDateTime actualArrivalTime);

    /**
     * 更新实际首站发车时间
     *
     * @param loadingId
     * @param actualSendTime
     */
    void updateActualSendTime(@Param(value = "loadingId") Integer loadingId,
                              @Param(value = "actualSendTime") LocalDateTime actualSendTime);

    /**
     * 更新实际完成时间
     *
     * @param loadingId
     * @param actualCompleteTime
     */
    void updateActualCompleteTime(@Param(value = "loadingId") Integer loadingId,
                                  @Param(value = "actualCompleteTime") LocalDateTime actualCompleteTime);

    /**
     * 批量插入 运单站点关联表
     *
     * @param loadingId
     * @param ids
     */
    void addStationMsg(@Param(value = "loadingId") Integer loadingId,@Param(value = "stationIds") List<Integer> ids);
}
