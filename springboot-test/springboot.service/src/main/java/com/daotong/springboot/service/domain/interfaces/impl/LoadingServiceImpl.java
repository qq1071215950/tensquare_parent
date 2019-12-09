package com.daotong.springboot.service.domain.interfaces.impl;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.interfaces.LoadingService;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingMapper;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.LoadingStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/6 17:52
 */
@Service
public class LoadingServiceImpl implements LoadingService {
    @Autowired(required = false)
    private LoadingMapper loadingMapper;
    @Autowired(required = false)
    private LoadingStationMapper loadingStationMapper;
    @Override
    public int saveLoading(LoadingDTO loading) {
        int i = loadingMapper.saveLoading(loading);
        return i;
    }

    @Override
    public List<LoadingDTO> getByQueryParam(LoadingQueryParam loadingQueryParam) {
        return loadingMapper.getByQueryParam(loadingQueryParam);
    }

    @Override
    public int deleteLoading(Integer loadingId) {
        int i = loadingMapper.deleteLoading(loadingId);
        if(i<1){
            throw new RuntimeException("deleteFailed");
        }
        return i;
    }

    @Override
    public void manualComplete(Integer loadingId, LocalDateTime completeTime) {
        //运单表修改完成状态
        loadingMapper.manualComplete(loadingId,completeTime);
        //运单站点表修改
        loadingStationMapper.setManualComplete(loadingId);
    }
}