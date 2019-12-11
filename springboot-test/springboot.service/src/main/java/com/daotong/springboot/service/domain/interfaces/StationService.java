package com.daotong.springboot.service.domain.interfaces;

import com.daotong.springboot.service.domain.bo.StationBO;
import com.daotong.springboot.service.domain.bo.UpdateStationBO;
import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.query.QueryStation;
import com.daotong.springboot.service.domain.vo.PageVO;
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
    void saveStation(StationBO station);

    /**
     * 删除站点
     *
     * @param id 站点id
     * @return
     */
    void removeStation(Integer id);

    /**
     * 修改站点信息
     *
     * @param station
     * @return
     */
    void updateStation(UpdateStationBO station);


    /**
     * 多条件分页查询站点信息
     * @param queryStation
     * @return
     */
    PageVO getStationList(QueryStation queryStation);
}
