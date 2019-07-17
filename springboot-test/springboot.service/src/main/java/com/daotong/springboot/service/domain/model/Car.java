package com.daotong.springboot.service.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 车辆信息
 */
@Getter
@Setter
public class Car {

    private Long id;

    /**
     *  商家编码
     */
    private String merchantCode;


    /**
     * 车辆编码
     */
    private String code;

    /**
     * 车型编码
     */
    private String carModelCode;
}
