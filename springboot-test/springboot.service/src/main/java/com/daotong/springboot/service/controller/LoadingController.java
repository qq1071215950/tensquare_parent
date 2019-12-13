package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.bo.LoadingBO;
import com.daotong.springboot.service.domain.bo.LoadingStationBO;
import com.daotong.springboot.service.domain.dto.LoadingDTO;
import com.daotong.springboot.service.domain.dto.LoadingQueryParam;
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
    public RestResponse createLoading(@RequestBody LoadingBO loading) {
        loadingService.saveLoading(loading);
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
    public RestResponse manualComplete(@ApiParam(value = "运单id") @RequestParam(value = "loadingId") Long loadingId){
        loadingService.manualComplete(loadingId);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "POST",value = "运单详情编辑")
    @PostMapping("/update")
    public RestResponse updateLoadingMsg(@RequestBody LoadingDTO loadingDTO){
        loadingService.updateLoadingMsg(loadingDTO);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "GET",value = "运单发布")
    @GetMapping("/publish")
    public RestResponse publishLoading(@RequestParam(value = "loadingIds") Long[] loadingIds){
        loadingService.publish(loadingIds);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "POST",value = "进站")
    @PostMapping("/loading_station/enter")
    public RestResponse enterStation(LoadingStationEnterParam loadingStationEnterParam){
        loadingStationService.enterStation(loadingStationEnterParam);
        return RestResponse.success();
    }
    @ApiOperation(httpMethod = "POST",value = "出站")
    @PostMapping("/loading_station/out")
    public RestResponse leaveStation(LoadingStationEnterParam loadingStationEnterParam){
        loadingStationService.leaveStation(loadingStationEnterParam);
        return RestResponse.success();
    }
}