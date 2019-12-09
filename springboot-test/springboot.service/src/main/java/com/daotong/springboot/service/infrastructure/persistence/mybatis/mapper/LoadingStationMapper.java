package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import com.daotong.springboot.service.domain.model.LoadingStation;
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
     * @param loadingNo
     * @param stationId
     * @return
     */
    int updateActualArrivalTime(@Param(value = "actualArrivalTime") LocalDateTime actualArrivalTime,
                                @Param(value = "stationId")Integer stationId,
                                @Param(value = "loadingNo")String loadingNo);

    /**
     * 更新站点实际出发时间
     * @param actualSendTime
     * @param loadingNo
     * @param stationId
     * @return
     */
    int updateActualSendTime(@Param(value = "actualSendTime") LocalDateTime actualSendTime,
                             @Param(value = "stationId")Integer stationId,
                             @Param(value = "loadingNo")String loadingNo);

    /**
     * 更新运单站点状态
     * @param loadingStationStatus
     * @param loadingNo
     * @param stationId
     * @return
     */
    int updateLoadingStationStatus(@Param(value = "loadingStationStatus") String loadingStationStatus,
                                   @Param(value = "loadingNo")String loadingNo,
                                   @Param(value = "stationId")Integer stationId);

    /**
     * 根据站点id获取当前运单所在站点状态
     * @param stationId
     * @param loadingNo
     * @return
     */
    LoadingStation getLoadingStationByStationId(@Param(value = "stationId") Integer stationId,
                                                @Param(value = "loadingNo")String loadingNo
                                                );

    /**
     * 根据运单号将所有状态设置为完成
     *
     * @param loadingId
     */
    void setManualComplete(@Param(value = "loadingId") Integer loadingId);

    /**
     * 根据运单id删除相关记录
     *
     * @param loadingId
     */
    void removeLoadingStation(@Param(value = "loadingId") Integer loadingId);
}
