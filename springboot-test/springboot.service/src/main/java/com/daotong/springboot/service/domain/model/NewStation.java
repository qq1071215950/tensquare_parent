package com.daotong.springboot.service.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class NewStation {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String provinceCode;

    private String cityName;

    private String cityCode;

    private String areaName;

    private String areaCode;

    private Date gmtCreate;

    private Date gmtModified;

}