package com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper;

import com.daotong.springboot.service.infrastructure.persistence.mybatis.dataobject.CarDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
@Mapper
public interface CarMapper {

    /**
     * 根据编码获取
     * @param code
     * @return
     */
    CarDO getByCode(@Param("code") String code);
}
