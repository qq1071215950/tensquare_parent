package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.dto.StationQueryParam;
import com.daotong.springboot.service.domain.vo.StationVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Zdh 2019/12/6 10:08
 */
public interface StationService {
    /**
     * 增加站点
     *
     * @param station
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int saveStation(StationDTO station);

    /**
     * 删除站点
     *
     * @param id 站点id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int removeStation(Integer id);

    /**
     * 修改站点信息
     *
     * @param station
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    int updateStation(StationDTO station);

    /**
     * 分页获取站点信息
     *
     * @param stationQueryParam
     * @return
     */
    List<StationVO> getStationList(StationQueryParam stationQueryParam);

}
