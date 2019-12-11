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
@ApiModel(value = "进出站参数封装类")
public class LoadingStationEnterParam {
    @ApiModelProperty(value = "站点状态信息id",required = true)
    private Integer id;
    @ApiModelProperty(value = "运单id",required = true)
    private Integer loadingId;
    @ApiModelProperty(value = "站点序号",required = true)
    private Integer seq;
    @ApiModelProperty(value = "运单包含的站点序号集合",required = true)
    private ArrayList<Integer> seqs;
    @ApiModelProperty(value = "站点实际到达时间",notes = "进站必须参数")
    private LocalDateTime actualArrivalTime;
    @ApiModelProperty(value = "站点实际发车时间",notes = "出站必须参数")
    private LocalDateTime actualSendTime;
}