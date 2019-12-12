package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.enums.LoadingEnum;
import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import com.daotong.springboot.service.domain.interfaces.LoadingService;
import com.daotong.springboot.service.domain.vo.LoadingVO;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingStationMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.StationMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Zdh 2019/12/6 17:52
 */
@Service
@Slf4j
public class LoadingServiceImpl implements LoadingService {
    @Autowired(required = false)
    private LoadingMapper loadingMapper;
    @Autowired(required = false)
    private LoadingStationMapper loadingStationMapper;
    @Autowired(required = false)
    private StationMapper stationMapper;
    @Override
    public int saveLoading(LoadingDTO loading) {
        //根据时间戳生成ID作为运单ID
        Long loadingId = getID();
        loading.setLoadingId(loadingId);
        //生成运单号 字母拼接时间戳
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = formatter.format(LocalDateTime.now());
        String loadingNo = "L"+timestamp;
        loading.setLoadingNo(loadingNo);
        //设置订单状态为初始化
        loading.setLoadingStatus(LoadingEnum.ARRIVAL.getLoadingStatus());
        //运单-站点状态信息添加
        List<LoadingStationDTO> loadingStations= loading.getStations();
        if(loadingStations==null){
            throw new RuntimeException("Empty Stations");
        }
        for (int i = 0; i < loadingStations.size(); i++) {
            LoadingStationDTO loadingStation = loadingStations.get(i);
            //运单站点状态初始化并更新到数据库
            loadingStation.setStationStatus(LoadingStationEnum.UN_START.getStatus());
            loadingStation.setLoadingId(loadingId);
            loadingStationMapper.addRelations(loadingStation);
        }
        int i = loadingMapper.saveLoading(loading);
        return i;
    }

    @Override
    public List<LoadingVO> getByQueryParam(LoadingQueryParam loadingQueryParam) {
        log.info(loadingQueryParam.toString());
        Integer curPage = loadingQueryParam.getCurPage();
        Integer pageSize = loadingQueryParam.getPageSize();
        if(curPage<1||pageSize<1){
            throw new RuntimeException("Illegal MethodParam: pageSize/curPage");
        }
        PageHelper.startPage(curPage,pageSize);
        Page<LoadingVO> byQueryParam = loadingMapper.getByQueryParam(loadingQueryParam);
        if(byQueryParam==null){
            return null;
        }
        //填充站点状态信息
        List<LoadingVO> result = byQueryParam.getResult();
        for (LoadingVO loadingVO : result) {
            loadingVO.setStations(stationMapper.getByLoadingId(loadingVO.getLoadingId()));
        }
        return result;
    }

    @Override
    public void manualComplete(Long loadingId, LocalDateTime completeTime) {
        //运单表修改完成状态
        loadingMapper.manualComplete(loadingId,completeTime);
        //运单站点表修改
        loadingStationMapper.setManualComplete(loadingId);
    }

    @Override
    public void updateLoadingMsg(LoadingDTO loadingDTO) {
        //可编辑状态校验
        String stationStatus = loadingDTO.getLoadingStatus();
        if(!LoadingEnum.ARRIVAL.getLoadingStatus().equals(stationStatus)){
            throw new RuntimeException("当前状态不可编辑");
        }
        loadingMapper.updateLoading(loadingDTO);
        //站点状态信息更新
        List<LoadingStationDTO> stations = loadingDTO.getStations();
        //删除原有站点联系
        loadingStationMapper.removeLoadingStations(loadingDTO.getLoadingId());
        for (LoadingStationDTO station : stations) {
            loadingStationMapper.addRelations(station);
        }

    }

    @Override
    public void publish(Long [] loadingIds) {
        for (int i = 0; i < loadingIds.length; i++) {
            loadingMapper.updatePublish(loadingIds[i]);
        }
    }

    /**
     * 生成随机ID
     * @return
     */
    private Long getID(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = formatter.format(LocalDateTime.now());
        return Long.valueOf(timestamp);
    }

}