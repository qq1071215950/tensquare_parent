package com.daotong.springboot.service.infrastructure.translator;

import com.daotong.springboot.service.domain.model.Car;
import com.daotong.springboot.service.infrastructure.persistence.mybatis.dataobject.CarDO;

/**
 * 车辆转换类
 */
public class CarTranslator {

    public static Car transFromDo(CarDO carDO) {
        if (carDO == null) {
            return null;
        }

        Car car = new Car();
        car.setId(carDO.getId());
        car.setCode(carDO.getCode());
        car.setCarModelCode(carDO.getCarModelCode());
        car.setMerchantCode(carDO.getMerchantCode());

        return car;
    }
}
