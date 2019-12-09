package com.daotong.springboot.service.infrastructure.translator;

import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.vo.StationVO;

/**
 * @author Zdh 2019/12/6 10:34
 */
public class StationTranslator {
    public static StationVO transform(StationDTO stationDTO) {
        if (stationDTO != null) {
            StationVO station = new StationVO();
            station.setId(stationDTO.getId());
            station.setCode(stationDTO.getCode());
            station.setName(stationDTO.getName());
            station.setProvinceName(stationDTO.getProvinceName());
            station.setCityName(stationDTO.getCityName());
            station.setAreaName(stationDTO.getAreaName());
            station.setLineName(stationDTO.getLineName());
            station.setLoadingStation(stationDTO.getLoadingStation());
            return station;
        }
        return null;
    }
}