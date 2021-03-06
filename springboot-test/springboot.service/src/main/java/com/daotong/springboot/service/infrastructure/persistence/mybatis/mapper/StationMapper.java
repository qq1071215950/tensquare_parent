package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.model.NewStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    int saveStation(NewStation station);

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
    int updateStation(NewStation station);


    /**
     * 多条件分页查询
     * @param map
     * @return
     */
    List<NewStation> getStationList(Map<String, Object> map);

    int countStationByConditions(Map<String, Object> map);
    /**
     * 通过运单id获取运单包含的站点信息
     *
     * @param loadingId
     * @return
     */
    List<LoadingStationDTO> getByLoadingId(@Param(value = "loadingId") Long loadingId);

}
