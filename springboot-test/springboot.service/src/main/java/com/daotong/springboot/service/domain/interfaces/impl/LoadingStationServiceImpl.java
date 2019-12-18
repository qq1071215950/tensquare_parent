package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingStationEnterOrLeaveParam;
import com.daotong.springboot.service.domain.interfaces.LoadingStationService;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingStationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Zdh 2019/12/9 11:40
 */
@Service
@Slf4j
public class LoadingStationServiceImpl implements LoadingStationService {
    @Autowired(required = false)
    private LoadingStationMapper loadingStationMapper;
    @Autowired(required = false)
    private LoadingMapper loadingMapper;

    @Override
    public void enterStation(LoadingStationEnterOrLeaveParam loadingStation) {
        // 实际到达时间
        LocalDateTime actualArrivalTime = LocalDateTime.now();
        // 运单id
        Long loadingId = loadingStation.getLoadingId();
        // 站点信息id
        Integer loadingStationId = loadingStation.getId();
        // 站点序号
        Integer seq = loadingStation.getSeq();
        // 运单包含的所有站点序号集合
        ArrayList<Integer> seqs = loadingStationMapper.getSeqs(loadingId);
        log.info(seqs.toString());
        // 首站
        if (seq.equals(seqs.get(0))) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
            // 更新运单状态 首站到达
            loadingMapper.updateActualArrivalTime(loadingId, actualArrivalTime);
        }
        // 末站
        if (seq.equals(seqs.get(seqs.size() - 1))) {
            loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);
            // 更新运单状态
            loadingMapper.updateActualCompleteTime(loadingId, actualArrivalTime);
        }
        // 中途站点
        loadingStationMapper.updateActualArrivalTime(actualArrivalTime, loadingStationId);

    }

    @Override
    public void leaveStation(LoadingStationEnterOrLeaveParam loadingStation) {
        // 实际出发时间
        LocalDateTime actualSendTime = LocalDateTime.now();
        // 运单id
        Long loadingId = loadingStation.getLoadingId();
        // 站点信息id
        Integer loadingStationId = loadingStation.getId();
        Integer seq = loadingStation.getSeq();
        // 运单包含的所有站点序号集合
        ArrayList<Integer> seqs = loadingStationMapper.getSeqs(loadingId);
        // 首站
        if (seq.equals(seqs.get(0))) {
            loadingStationMapper.updateActualSendTime(actualSendTime, loadingStationId);
            // 更新运单状态 首站到达
            loadingMapper.updateActualSendTime(loadingId,actualSendTime);
        }
        // 出发
        loadingStationMapper.updateActualSendTime(actualSendTime, loadingStationId);
    }
}