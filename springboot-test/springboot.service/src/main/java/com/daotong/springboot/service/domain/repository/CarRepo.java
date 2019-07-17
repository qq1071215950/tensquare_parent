package com.daotong.springboot.service.domain.repository;

import com.daotong.springboot.service.domain.model.Car;

/**
 * 车辆持久化操作
 */
public interface CarRepo {

    Car getByCode(String code);
}
