package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
import com.daotong.springboot.service.domain.dto.LoadingStationDTO;
import com.daotong.springboot.service.domain.dto.LoadingStationEnterParam;
import com.daotong.springboot.service.domain.interfaces.LoadingService;
import com.daotong.springboot.service.domain.interfaces.LoadingStationService;
import com.daotong.springboot.service.domain.vo.LoadingVO;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Zdh 2019/12/9 10:23
 */
@Api(description = "运单接口详情", value = "API-LoadingController")
@RestController
@RequestMapping("/loading")
@CrossOrigin
public class LoadingController {
    @Autowired
    private LoadingService loadingService;
    @Autowired
    private LoadingStationService loadingStationService;

    @ApiOperation(httpMethod = "POST", value = "运单创建")
    @PostMapping("/create")
    public RestResponse createLoading(@RequestBody LoadingDTO loadingDTO) {
        loadingService.saveLoading(loadingDTO);
        return RestResponse.success();
    }

    @ApiOperation(httpMethod = "POST", value = "根据条件查询运单")
    @PostMapping("/query_by_condition")
    public RestResponse getByQueryParam(@RequestBody LoadingQueryParam loadingQueryParam) {
        List<LoadingVO> byQueryParam = loadingService.getByQueryParam(loadingQueryParam);
        return RestResponse.single(byQueryParam);
    }
    @ApiOperation(httpMethod = "GET",value = "手动完成运单接口")
    @GetMapping("/manual_complete")
    public RestResponse manualComplete(@ApiParam(value = "运单id") @RequestParam(value = "loadingId") Integer loadingId,
                                       @ApiParam(value = "当前时间")@RequestParam(value = "currentTime") LocalDateTime currentTime){
        loadingService.manualComplete(loadingId,currentTime);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "POST",value = "到达站点更新状态以及时间")
    @PostMapping("/update_status")
    public RestResponse updateArrivalTime(@RequestBody LoadingStationEnterParam loadingStationEnterParam){
        loadingStationService.updateStatus(loadingStationEnterParam);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "POST",value = "运单详情编辑")
    @PostMapping("/update")
    public RestResponse updateLoadingMsg(@RequestBody LoadingDTO loadingDTO){
        loadingService.updateLoadingMsg(loadingDTO);
        return RestResponse.success();
    }
}