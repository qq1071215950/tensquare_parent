package com.daotong.springboot.service.domain.dto;

import com.daotong.springboot.service.domain.model.LoadingStation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 站点信息传输类
 *
 * @author Zdh 2019/12/5 16:03
 */
@Data
public class StationDTO {
    private Integer id;

    private String code;

    private String name;

    private String provinceName;

    private String cityName;

    private String areaName;
    /**
     * 站点名称
     */
    private String lineName;
    /**
     * 当前页码
     */
    private Integer curPage;
    /**
     * 每页展示数量
     */
    private Integer pageSize;
    /**
     * 运单站点信息
     */
    private LoadingStationDTO loadingStation;

    public StationDTO(Integer id, String code, String name, String provinceName, String cityName, String areaName) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.areaName = areaName;
    }

    public StationDTO() {
    }
}