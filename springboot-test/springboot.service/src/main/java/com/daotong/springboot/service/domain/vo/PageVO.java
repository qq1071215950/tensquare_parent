package com.daotong.springboot.service.domain.vo;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class PageVO<T> {
    /**
     * 当前页
     */
    private Integer currPage;
    /**
     * 每一页大小
     */
    private Integer pageSize;
    /**
     * 记录数
     */
    private Integer total;
    /**
     * 查询结果
     */
    private T data;
}
