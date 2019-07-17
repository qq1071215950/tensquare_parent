package com.daotong.springboot.service.infrastructure.persistence.mybatis.dataobject;

import lombok.Data;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
@Data
public class CarDO {

    private Long id;

    private String merchantCode;

    private String code;

    private String carModelCode;
}
