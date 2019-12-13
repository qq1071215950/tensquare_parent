package com.daotong.springboot.service.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Zdh 2019/12/11 15:15
 */
@Setter
@Getter
@ApiModel(value = "进出站站点信息对象")
public class LoadingStationEnterParam {
    @ApiModelProperty(value = "站点状态信息id",required = true)
    private Integer id;
    @ApiModelProperty(value = "运单id",required = true)
    private Long loadingId;
    @ApiModelProperty(value = "站点序号",required = true)
    private Integer seq;
}