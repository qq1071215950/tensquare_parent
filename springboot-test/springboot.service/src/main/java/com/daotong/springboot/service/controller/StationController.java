package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.dto.StationQueryParam;
import com.daotong.springboot.service.domain.interfaces.StationService;
import com.daotong.springboot.service.domain.vo.StationVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Zdh 2019/12/6 10:52
 */
@Api(description = "站点接口详情",value = "API-StationController")
@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping("/save")
    @ApiOperation(httpMethod = "POST", value = "添加站点信息", code = 200, notes = "返回数据为受影响的行数")
    public RestResponse saveStation(@RequestBody StationDTO stationDTO) {
        int i = stationService.saveStation(stationDTO);
        return RestResponse.single(i);
    }

    @PostMapping("/update")
    @ApiOperation(httpMethod = "POST", value = "更新站点信息", notes = "返回数据为受影响的行数")
    public RestResponse updateStation(@RequestBody StationDTO stationDTO) {
        int i = stationService.updateStation(stationDTO);
        return RestResponse.single(i);
    }

    @GetMapping("/remove")
    @ApiOperation(httpMethod = "GET", value = "删除站点信息", notes = "返回数据为受影响的行数")
    public RestResponse removeStation(@ApiParam(name = "stationId", value = "站点id", required = true)
                                      @RequestParam("id")@NotNull Integer stationId) {
        int i = stationService.removeStation(stationId);
        return RestResponse.single(i);
    }

    @PostMapping("/get_by_page")
    @ApiOperation(httpMethod = "GET", value = "分页查询站点信息", notes = "分页结果")
    public RestResponse findByPage(@RequestBody StationQueryParam stationQueryParam) {
        List<StationVO> stationList = stationService.getStationList(stationQueryParam);
        return RestResponse.single(stationList);
    }
}