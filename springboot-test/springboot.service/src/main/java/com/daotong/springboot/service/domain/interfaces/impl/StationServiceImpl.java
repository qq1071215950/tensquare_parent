package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.bo.StationBO;
import com.daotong.springboot.service.domain.bo.UpdateStationBO;
import com.daotong.springboot.service.domain.interfaces.StationService;
import com.daotong.springboot.service.domain.model.NewStation;
import com.daotong.springboot.service.domain.query.QueryStation;
import com.daotong.springboot.service.domain.vo.NewStationVO;
import com.daotong.springboot.service.domain.vo.PageVO;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.StationMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Zdh 2019/12/6 10:15
 */
@Service
public class StationServiceImpl implements StationService {
    private static final Integer DEFAULT_CURRPAGE = 1;
    private static final Integer DEFAULT_PAGESIZE = 10;

    @Autowired
    private StationMapper stationMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStation(StationBO stationBO) {
        if (StringUtils.isBlank(stationBO.getCode())){
            throw new RuntimeException("站点编码不能为空");
        }
        if (StringUtils.isBlank(stationBO.getName())){
            throw new RuntimeException("站点名称不能为空");
        }
        if (StringUtils.isBlank(stationBO.getProvinceName())){
            throw new RuntimeException("省名称不能为空");
        }
        if (StringUtils.isBlank(stationBO.getCityName())){
            throw new RuntimeException("城市名称不能为空");
        }
        if (StringUtils.isBlank(stationBO.getAreaName())){
            throw new RuntimeException("区名称不能为空");
        }
        NewStation station = bo2Staion(stationBO);
        station.setGmtCreate(new Date());
        station.setGmtModified(new Date());
        int i = stationMapper.saveStation(station);
        if(i<1){
            throw new RuntimeException("insertFailed");
        }
    }
    private NewStation bo2Staion(StationBO stationBO){
        NewStation station = new NewStation();
        BeanUtils.copyProperties(stationBO,station);
        return station;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void removeStation(Integer id) {
        int i = stationMapper.removeStation(id);
        if(i<1){
            throw new RuntimeException("removeFailed");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStation(UpdateStationBO updateStationBO) {
        if (updateStationBO.getId() == null){
            throw new RuntimeException("站点Id不能为空");
        }
        NewStation station = updateBO2Station(updateStationBO) ;
        int i = stationMapper.updateStation(station);
        if(i<1){
            throw new RuntimeException("updateFailed");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public PageVO getStationList(QueryStation queryStation) {
        Integer currPage = queryStation.getCurPage();
        Integer pageSize = queryStation.getPageSize();
        if (currPage == null){
            currPage = DEFAULT_CURRPAGE;
        }
        if (pageSize == null){
            pageSize = DEFAULT_PAGESIZE;
        }
        Integer startIndex = (currPage-1)*pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex",startIndex);
        map.put("pageSize",pageSize);
        map.put("code",queryStation.getCode());
        map.put("name",queryStation.getName());
        map.put("provinceName",queryStation.getProvinceName());
        map.put("cityName",queryStation.getCityName());
        map.put("areaName",queryStation.getAreaName());
        List<NewStation> stationList = stationMapper.getStationList(map);
        Integer total = stationMapper.countStationByConditions(map);
        PageVO pageVO = new PageVO();
        if (! CollectionUtils.isEmpty(stationList)){
            List<NewStationVO> newStationVOList = stationList.stream()
                    .map(x ->{
                        NewStationVO newStationVO = new NewStationVO();
                        BeanUtils.copyProperties(x,newStationVO);
                        return newStationVO;
                    }).collect(Collectors.toList());
            pageVO.setData(newStationVOList);
        }
        pageVO.setCurrPage(currPage);
        pageVO.setPageSize(pageSize);
        pageVO.setTotal(total);
        return pageVO;
    }

    private NewStation updateBO2Station(UpdateStationBO updateStationBO){
        NewStation station = new   NewStation();
        BeanUtils.copyProperties(updateStationBO,station);
        return station;
    }
}