package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.dto.LoadingStationEnterParam;
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
    public void enterStation(LoadingStationEnterParam loadingStation) {
        //实际到达时间
        LocalDateTime actualArrivalTime = LocalDateTime.now();
        //运单id
        Long loadingId = loadingStation.getLoadingId();
        //站点信息id
        Integer loadingStationId = loadingStation.getId();
        //站点序号
        Integer seq = loadingStation.getSeq();
        //运单包含的所有站点序号集合
        ArrayList<Integer> seqs = loadingStationMapper.getSeqs(loadingId);
        //首站
        if (seq.equals(seqs.get(0))) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
            //更新运单状态 首站到达
            loadingMapper.updateActualArrivalTime(loadingId, actualArrivalTime);
        }
        //末站
        if (seq.equals(seqs.get(seqs.size() - 1))) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
            //更新运单状态
            loadingMapper.updateActualCompleteTime(loadingId, actualArrivalTime);
        }
        //中途站点
        loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);

    }

    @Override
    public void leaveStation(LoadingStationEnterParam loadingStation) {
        //实际出发时间
        LocalDateTime actualSendTime = LocalDateTime.now();
        //运单id
        Long loadingId = loadingStation.getLoadingId();
        //站点信息id
        Integer loadingStationId = loadingStation.getId();
        //出发
        loadingStationMapper.updateActualSendTime(actualSendTime, loadingStationId);
    }
}