package com.daotong.springboot.service.domain.vo;

import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.enums.LoadingStationEnum;
import com.daotong.springboot.service.domain.model.LoadingStation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Zdh 2019/12/6 10:08
 */
@Data
public class StationVO {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String provinceCode;

    private String cityName;

    private String cityCode;

    private String areaName;

    private String areaCode;

}