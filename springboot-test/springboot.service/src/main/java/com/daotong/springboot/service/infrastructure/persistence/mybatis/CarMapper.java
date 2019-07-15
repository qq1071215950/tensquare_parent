package com.daotong.springboot.service.infrastructure.persistence.mybatis;

import com.daotong.springboot.service.domain.repository.CarDO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

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
