package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/5 16:46
 */
@Mapper
public interface LoadingMapper {
    /**
     * 创建订单
     *
     * @param loading
     * @return
     */
    int saveLoading(LoadingDTO loading);

    /**
     * 根据条件组合查询运单
     *
     * @param loadingQueryParam
     * @return
     */
    List<LoadingDTO> getByQueryParam(LoadingQueryParam loadingQueryParam);

    /**
     * 根据id删除运单
     *
     * @param loadingId
     * @return
     */
    int deleteLoading(@Param(value = "loadingId") Integer loadingId);

    /**
     * 手动设置完成运单
     *
     * @param loadingId
     * @param complateTime
     */
    void manualComplete(@Param(value = "loadingId") Integer loadingId, @Param(value = "complateTime") LocalDateTime complateTime);

}
