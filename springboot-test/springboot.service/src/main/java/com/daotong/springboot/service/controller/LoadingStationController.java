package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.interfaces.LoadingStationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Zdh 2019/12/9 11:33
 */
@Api(description = "运单站点状态接口详情", value = "API-LoadingStationController")
@RestController
@RequestMapping("/loading_station")
public class LoadingStationController {
    @Autowired
    private LoadingStationService loadingStationService;
    @ApiOperation(httpMethod = "POST",value = "到达站点更新状态以及时间")
    @PostMapping("/update_status")
    public RestResponse updateArrivalTime(@RequestBody LoadingStationDTO loadingStationDTO){
        loadingStationService.updateStatus(loadingStationDTO);
        return RestResponse.success();
    }
}