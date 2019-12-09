package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.interfaces.StationService;
import com.daotong.springboot.service.domain.vo.StationVO;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.StationMapper;
import com.daotong.springboot.service.infrastructure.translator.StationTranslator;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zdh 2019/12/6 10:15
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired(required = false)
    private StationMapper stationMapper;
    @Override
    public int saveStation(StationDTO station) {
        int i = stationMapper.saveStation(station);
        if(i<1){
            throw new RuntimeException("insertFailed");
        }
        return i;
    }

    @Override
    public int removeStation(Integer id) {
        //参数校验
        if(StringUtils.isEmpty(id)&&id<0){
            throw new IllegalArgumentException("IllegalArg");
        }
        int i = stationMapper.removeStation(id);
        if(i<1){
            throw new RuntimeException("removeFailed");
        }
        return i;
    }

    @Override
    public int updateStation(StationDTO station) {
        int i = stationMapper.updateStation(station);
        if(i<1){
            throw new RuntimeException("updateFailed");
        }
        return 0;
    }

    @Override
    public List<StationVO> getStationList(StationDTO stationDTO) {
        PageHelper.startPage(stationDTO.getCurPage(),stationDTO.getPageSize());
        Page<StationDTO> stationList = stationMapper.getStationList(stationDTO);
        ArrayList<StationVO> stations = new ArrayList<>();
        List<StationDTO> result = stationList.getResult();
        for (StationDTO dto : result) {
            StationVO vo = StationTranslator.transform(dto);
            stations.add(vo);
        }
        return stations;
    }

    @Override
    public List<StationVO> getByLoadingNo(String loadingNo) {
        //非空判断
        if(StringUtils.isEmpty(loadingNo)){
            throw new IllegalArgumentException("IllegalArg");
        }
        List<StationDTO> byLoadingNo = stationMapper.getByLoadingNo(loadingNo);
        ArrayList<StationVO> stations = new ArrayList<>();
        for (StationDTO stationDTO : byLoadingNo) {
            StationVO transform = StationTranslator.transform(stationDTO);
            stations.add(transform);
        }
        return stations;
    }

    @Override
    public StationVO getByStationId(Integer stationId) {
        //参数校验
        if(StringUtils.isEmpty(stationId)&&stationId<0){
            throw new IllegalArgumentException("IllegalArg");
        }
        StationDTO byStationId = stationMapper.getByStationId(stationId);
        return StationTranslator.transform(byStationId);
    }
}