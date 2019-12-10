package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.enums.LoadingEnum;
import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import com.daotong.springboot.service.domain.interfaces.LoadingService;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingStationMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.StationMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author Zdh 2019/12/6 17:52
 */
@Service
public class LoadingServiceImpl implements LoadingService {
    @Autowired(required = false)
    private LoadingMapper loadingMapper;
    @Autowired(required = false)
    private LoadingStationMapper loadingStationMapper;
    @Autowired(required = false)
    private StationMapper stationMapper;
    @Override
    public int saveLoading(LoadingDTO loading) {
        //随机生成UUID作为运单ID
        Integer loadingId = getUUID();
        loading.setLoadingId(loadingId);
        //生成运单号 字母拼接时间戳
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = formatter.format(LocalDateTime.now());
        String loadingNo = "L"+timestamp;
        loading.setLoadingNo(loadingNo);
        //设置订单状态为初始化
        loading.setLoadingEnum(LoadingEnum.ARRIVAL);
        //设置计划首站发车时间
        loading.setPlanSendTime(loading.getPlanSendTime());
        //首站计划到达时间
        loading.setPlanArrivalTime(loading.getPlanArrivalTime());
        //运单-站点关联添加
        List<StationDTO> stations = loading.getStations();
        ArrayList<Integer> stationIds = new ArrayList<>();
        if(stations==null){
            throw new RuntimeException("Empty Stations");
        }
        for (int i = 0; i < stations.size(); i++) {
            StationDTO station = stations.get(i);
            stationIds.add(station.getId());
            //运单站点状态初始化并更新到数据库
            LoadingStationDTO loadingStation = station.getLoadingStation();
            loadingStation.setStationStatus(LoadingStationEnum.UN_START.getStatus());
            loadingStationMapper.addRelations(loadingStation);
        }
        loadingMapper.addStationMsg(loadingId,stationIds);
        int i = loadingMapper.saveLoading(loading);
        return i;
    }

    @Override
    public List<LoadingDTO> getByQueryParam(LoadingQueryParam loadingQueryParam) {
        PageHelper.startPage(loadingQueryParam.getCurPage(),loadingQueryParam.getPageSize());
        Page<LoadingDTO> byQueryParam = loadingMapper.getByQueryParam(loadingQueryParam);
        if(byQueryParam==null){
            return null;
        }
        //填充站点状态信息
        List<LoadingDTO> result = byQueryParam.getResult();
        for (LoadingDTO loadingDTO : result) {
            loadingDTO.setStations(stationMapper.getByLoadingId(loadingQueryParam.getLoadingId()));
        }
        return result;
    }

    @Override
    public void manualComplete(Integer loadingId, LocalDateTime completeTime) {
        //运单表修改完成状态
        loadingMapper.manualComplete(loadingId,completeTime);
        //运单站点表修改
        loadingStationMapper.setManualComplete(loadingId);
    }

    /**
     * 生成随机ID
     * @return
     */
    private Integer getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String replace = str.replace("-", "");
        return Integer.valueOf(replace);
    }

}