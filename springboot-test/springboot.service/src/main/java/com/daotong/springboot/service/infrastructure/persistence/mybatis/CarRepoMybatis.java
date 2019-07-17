package com.daotong.springboot.service.infrastructure.persistence.mybatis;

import com.daotong.springboot.service.domain.model.Car;
import com.daotong.springboot.service.domain.repository.CarRepo;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.dataobject.CarDO;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.mapper.CarMapper;
import com.daotong.springboot.service.infrastructure.translator.CarTranslator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepoMybatis implements CarRepo {

    @Autowired
    private CarMapper carMapper;

    @Override
    public Car getByCode(String code) {

        // 此处一定要防御，不然会击穿数据库
        if (StringUtils.isBlank(code)) {
            return null;
        }

        CarDO carDO = carMapper.getByCode(code);

        if (carDO == null) {
            return null;
        }

        return CarTranslator.transFromDo(carDO);
    }
}
