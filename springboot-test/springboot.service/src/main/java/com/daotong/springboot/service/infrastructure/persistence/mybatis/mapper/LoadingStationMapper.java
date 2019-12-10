package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/5 16:32
 */
@Mapper
public interface LoadingStationMapper {
    /**
     * 更新运单状态实际到达时间
     * @param actualArrivalTime
     * @param loadingStationId
     * @return
     */
    int updateActualArrivalTime(@Param(value = "actualArrivalTime") LocalDateTime actualArrivalTime,
                                @Param(value = "loadingStationId") Integer loadingStationId);

    /**
     * 更新站点实际出发时间
     * @param actualSendTime
     * @param loadingStationId
     * @return
     */
    int updateActualSendTime(@Param(value = "actualSendTime") LocalDateTime actualSendTime,
                             @Param(value = "loadingStationId") Integer loadingStationId);

    /**
     * 根据运单号将所有状态设置为完成
     *
     * @param loadingId
     */
    void setManualComplete(@Param(value = "loadingId") Integer loadingId);

}
