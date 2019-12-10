package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import com.daotong.springboot.service.domain.interfaces.LoadingStationService;
import com.daotong.springboot.service.domain.model.LoadingStation;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Zdh 2019/12/9 11:40
 */
@Service
public class LoadingStationServiceImpl implements LoadingStationService {
    @Autowired(required = false)
    private LoadingStationMapper loadingStationMapper;
    @Autowired(required = false)
    private LoadingMapper loadingMapper;

    @Override
    public void updateStatus(LoadingStationDTO loadingStationDTO) {
        //运单id
        Integer loadingId = loadingStationDTO.getLoadingId();
        //当前站点序号
        Integer seq = loadingStationDTO.getSeq();
        //运单包含的所有站点序号集合
        ArrayList<Integer> seqs = loadingStationDTO.getSeqs();
        //实际到达时间
        LocalDateTime actualArrivalTime = loadingStationDTO.getActualArrivalTime();
        //实际出发时间
        LocalDateTime actualSendTime = loadingStationDTO.getActualSendTime();
        //站点状态id
        Integer loadingStationId = loadingStationDTO.getLoadingStationId();
        //首站
        if(seq.equals(seqs.get(0))){
            updateToLoading(actualArrivalTime,actualSendTime,loadingStationId,loadingId);
        }
        //末站
        if(seq.equals(seqs.get(seqs.size()-1))){
            updateCompleteToLoading(actualArrivalTime,loadingStationId,loadingId);
        }
        //中途站点
        updateLoadingStationStatus(actualArrivalTime,actualSendTime,loadingStationId);
    }

    /**
     * 首站更新并更新到运单表
     *
     * @param actualArrivalTime
     * @param actualSendTime
     * @param loadingStationId
     * @param loadingId
     */
    private void updateToLoading(LocalDateTime actualArrivalTime,
                                        LocalDateTime actualSendTime,
                                        Integer loadingStationId,
                                        Integer loadingId){
        //到达
        if (actualArrivalTime!=null) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
            loadingMapper.updateActualArrivalTime(loadingId,actualArrivalTime);
        }
        //出发
            loadingStationMapper.updateActualSendTime(actualSendTime,loadingStationId);
            loadingMapper.updateActualSendTime(loadingId,actualSendTime);
    }

    /**
     * 中途站点更新
     * @param actualArrivalTime
     * @param actualSendTime
     * @param loadingStationId
     */
    private void updateLoadingStationStatus(LocalDateTime actualArrivalTime,
                              LocalDateTime actualSendTime,
                              Integer loadingStationId){
        //到达
        if (actualArrivalTime!=null) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
        }
        //出发
        loadingStationMapper.updateActualSendTime(actualSendTime,loadingStationId);
    }

    /**
     * 末站到达更新运单为完成状态
     * @param actualArrivalTime
     * @param loadingStationId
     * @param loadingId
     */
    private void updateCompleteToLoading(LocalDateTime actualArrivalTime,Integer loadingStationId,Integer loadingId){
        loadingStationMapper.updateActualArrivalTime(actualArrivalTime,loadingStationId);
        //更新运单状态
        loadingMapper.updateActualCompleteTime(loadingId,actualArrivalTime);
    }
}