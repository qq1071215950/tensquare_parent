package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.bo.LoadingBO;
import com.daotong.springboot.service.domain.bo.LoadingStationBO;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    /**
     * 站点最小数量
     */
    private static final int MIN_LOADING_STATION_COUNT = 1;
    @Override
    public int saveLoading(LoadingBO loading) {
        // 运单参数校验
        validArgs(loading);
        LoadingDTO transfer = transfer(loading);
        // 根据时间戳生成ID作为运单ID
        Long loadingId = getID();
        transfer.setLoadingId(loadingId);
        // 生成运单号 字母拼接时间戳
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = formatter.format(LocalDateTime.now());
        String loadingNo = "L" + timestamp;
        transfer.setLoadingNo(loadingNo);
        // 设置订单状态为初始化
        transfer.setLoadingStatus(LoadingEnum.ARRIVAL.getLoadingStatus());
        // 运单-站点状态信息添加
        List<LoadingStationBO> loadingStations = loading.getStations();
        // 站点信息校验
        validLoadingStation(loadingStations);
        // 运单站点状态初始化并更新到数据库
        for (int i = 0; i < loadingStations.size(); i++) {
            LoadingStationBO loadingStation = loadingStations.get(i);
            LoadingStationDTO loadingStationDTO = transfer(loadingStation);
            loadingStationDTO.setStationStatus(LoadingStationEnum.UN_START.getStatus());
            loadingStationDTO.setLoadingId(loadingId);
            loadingStationMapper.addRelations(loadingStationDTO);
        }
        // 设置首站计划到达时间
        transfer.setPlanArrivalTime(loadingStations.get(0).getPlanArrivalTime());
        // 设置首站出发时间
        transfer.setPlanSendTime(loadingStations.get(0).getPlanSendTime());
        int i = loadingMapper.saveLoading(transfer);
        if(i<1){
            throw new RuntimeException("创建失败");
        }
        return i;
    }

    @Override
    public List<LoadingVO> getByQueryParam(LoadingQueryParam loadingQueryParam) {
        log.info(loadingQueryParam.toString());
        List<LoadingVO> byQueryParam = loadingMapper.getByQueryParam(loadingQueryParam);
        if (byQueryParam == null) {
            return null;
        }
        // 填充站点状态信息
        for (LoadingVO loadingVO : byQueryParam) {
            loadingVO.setStations(stationMapper.getByLoadingId(loadingVO.getLoadingId()));
        }
        return byQueryParam;
    }

    @Override
    public void manualComplete(Long loadingId) {
        // 运单id可用校验
        LoadingQueryParam loadingQueryParam = new LoadingQueryParam();
        loadingQueryParam.setLoadingId(loadingId);
        List<LoadingVO> byQueryParam = loadingMapper.getByQueryParam(loadingQueryParam);
        if (byQueryParam == null) {
            throw new RuntimeException("无效运单ID");
        }
        LocalDateTime completeTime = LocalDateTime.now();
        // 运单表修改完成状态
        loadingMapper.manualComplete(loadingId, completeTime);
        // 运单站点表修改
        loadingStationMapper.setManualComplete(loadingId);
    }

    @Override
    public void updateLoadingMsg(LoadingDTO loadingDTO) {
        // 可编辑状态校验
        String stationStatus = loadingDTO.getLoadingStatus();
        if (!LoadingEnum.ARRIVAL.getLoadingStatus().equals(stationStatus)) {
            throw new RuntimeException("当前状态不可编辑");
        }
        loadingMapper.updateLoading(loadingDTO);
        // 站点状态信息更新
        List<LoadingStationDTO> stations = loadingDTO.getStations();
        // 删除原有站点联系
        loadingStationMapper.removeLoadingStations(loadingDTO.getLoadingId());
        for (LoadingStationDTO station : stations) {
            loadingStationMapper.addRelations(station);
        }

    }

    @Override
    public void publish(Long[] loadingIds) {
        for (int i = 0; i < loadingIds.length; i++) {
            loadingMapper.updatePublish(loadingIds[i]);
        }
    }

    /**
     * 生成ID
     *
     * @return
     */
    private Long getID() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timestamp = formatter.format(LocalDateTime.now());
        return Long.valueOf(timestamp);
    }

    /**
     * 参数校验
     * @param loading
     */
    private void validArgs(LoadingBO loading){
        // 参数校验
        String lineName = loading.getLineName();
        if(StringUtils.isEmpty(lineName)){
            throw new RuntimeException("线路名称不能为空");
        }
        String saler = loading.getSaler();
        if(StringUtils.isEmpty(saler)){
            throw new RuntimeException("商家不能为空");
        }
        String temperatureLayer = loading.getTemperatureLayer();
        if(StringUtils.isEmpty(temperatureLayer)){
            throw new RuntimeException("温层不能为空");
        }
        String forwarder = loading.getForwarder();
        if(StringUtils.isEmpty(forwarder)){
            throw new RuntimeException("运输商不能为空");
        }
        String plateNo = loading.getPlateNo();
        if(StringUtils.isEmpty(plateNo)){
            throw new RuntimeException("车牌不能为空");
        }
        String priceQuote = loading.getPriceQuote();
        if(StringUtils.isEmpty(priceQuote)){
            throw new RuntimeException("报价方式不能为空");
        }
        String driverName = loading.getDriverName();
        if(StringUtils.isEmpty(driverName)){
            throw new RuntimeException("司机姓名不能为空");
        }
        List<LoadingStationBO> loadingStations = loading.getStations();
        // 站点信息为空校验
        if (loadingStations == null) {
            throw new RuntimeException("Empty Stations");
        }
    }

    /**
     * 添加的运单站点信息校验
     *
     * @param loadingStations
     */
    private void validLoadingStation(List<LoadingStationBO> loadingStations){
        // 计划发车到达时间校验
        for (LoadingStationBO loadingStation : loadingStations) {
            LocalDateTime planArrivalTime = loadingStation.getPlanArrivalTime();
            LocalDateTime planSendTime = loadingStation.getPlanSendTime();
            if(planArrivalTime==null||planSendTime==null){
                throw new RuntimeException("计划发车/到达时间不能为空");
            }
        }
        // 重复站点校验
        int size = loadingStations.size();
        if(size !=MIN_LOADING_STATION_COUNT){
            for (int i = size-1; i > 0; i--) {
                if(loadingStations.get(i).equals(loadingStations.get(i-1))){
                    throw new RuntimeException("站点信息重复");
                }
            }
        }
    }

    /**
     * 转换对象
     *
     * @param loading
     * @return
     */
    private LoadingDTO transfer(LoadingBO loading){
        LoadingDTO loadingDTO = new LoadingDTO();
        loadingDTO.setSendStationId(loading.getSendStationId());
        loadingDTO.setEndStationId(loading.getEndStationId());
        loadingDTO.setDriverName(loading.getDriverName());
        loadingDTO.setForwarder(loading.getForwarder());
        loadingDTO.setLineName(loading.getLineName());
        loadingDTO.setStationCount(loading.getStationCount());
        loadingDTO.setPlateNo(loading.getPlateNo());
        loadingDTO.setPriceQuote(loading.getPriceQuote());
        loadingDTO.setSaler(loading.getSaler());
        loadingDTO.setTel(loading.getTel());
        loadingDTO.setTemperatureLayer(loading.getTemperatureLayer());
        loadingDTO.setPlanCompleteTime(loading.getPlanCompleteTime());
        return loadingDTO;
    }
    private LoadingStationDTO transfer(LoadingStationBO loadingStation){
        LoadingStationDTO loadingStationDTO = new LoadingStationDTO();
        loadingStationDTO.setSeq(loadingStation.getSeq());
        loadingStationDTO.setStationName(loadingStation.getStationName());
        loadingStationDTO.setStationId(loadingStation.getStationId());
        loadingStationDTO.setPlanArrivalTime(loadingStation.getPlanArrivalTime());
        loadingStationDTO.setPlanSendTime(loadingStation.getPlanSendTime());
        return loadingStationDTO;
    }
}