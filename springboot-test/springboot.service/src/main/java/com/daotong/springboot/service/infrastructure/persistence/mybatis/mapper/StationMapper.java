package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.model.Station;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zdh 2019/12/5 15:54
 */
@Mapper
public interface StationMapper {
    /**
     * 增加站点
     *
     * @param station
     * @return
     */
    int saveStation(StationDTO station);

    /**
     * 删除站点
     *
     * @param id 站点id
     * @return
     */
    int removeStation(@Param(value = "id") Integer id);

    /**
     * 修改站点信息
     *
     * @param station
     * @return
     */
    int updateStation(StationDTO station);

    /**
     * 分页获取站点信息
     *
     * @param stationDTO
     * @return
     */
    Page<StationDTO> getStationList(StationDTO stationDTO);

    /**
     * 通过运单号获取运单包含的站点信息
     *
     * @param loadingId
     * @return
     */
    List<StationDTO> getByLoadingId(@Param(value = "loadingId") Integer loadingId);

    /**
     * 根据站点id
     *
     * @param stationId
     * @return
     */
    StationDTO getByStationId(@Param(value = "stationId")Integer stationId);
}
