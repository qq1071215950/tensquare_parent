package com.daotong.springboot.service.domain.query;

import lombok.Data;

/**
 * 前端查询站点信息对象
 */
@Data
public class QueryStation {
    /**
     * 站点编码
     */
    private String code;

    /**
     * 站点名称
     */
    private String name;

    /**
     * 省名
     */
    private String provinceName;

    /**
     * 城市名
     */
    private String cityName;

    /**
     * 地区名
     */
    private String areaName;

    /**
     * 当前页
     */
    private Integer curPage;
    /**
     * 每页展示数量
     */
    private Integer pageSize;
}
