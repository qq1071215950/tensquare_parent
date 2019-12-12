package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.bo.StationBO;
import com.daotong.springboot.service.domain.bo.UpdateStationBO;
import com.daotong.springboot.service.domain.interfaces.StationService;
import com.daotong.springboot.service.domain.query.QueryStation;
import com.daotong.springboot.service.domain.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zdh 2019/12/6 10:52
 */
@Api(description = "站点接口详情",value = "API-StationController")
@RestController
@RequestMapping("/station")
@CrossOrigin
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping("/save")
    @ApiOperation(httpMethod = "POST", value = "添加站点信息", code = 200, notes = "添加站点信息")
    public RestResponse saveStation(@RequestBody StationBO stationBO) {
        stationService.saveStation(stationBO);
        return RestResponse.success();
    }

    @PostMapping("/update")
    @ApiOperation(httpMethod = "POST", value = "更新站点信息", notes = "更新站点信息")
    public RestResponse updateStation(@RequestBody UpdateStationBO updateStationBO) {
        stationService.updateStation(updateStationBO);
        return RestResponse.success();
    }

    @GetMapping("/remove")
    @ApiOperation(httpMethod = "GET", value = "删除站点信息", notes = "删除站点信息")
    public RestResponse removeStation(@ApiParam(name = "id", value = "站点id", required = true)
                                      @RequestParam Integer id) {
        stationService.removeStation(id);
        return RestResponse.success();
    }

    @ApiOperation(httpMethod = "POST", value = "分页查询站点信息", notes = "分页查询站点信息")
    @RequestMapping(value = "/get_by_page",method = RequestMethod.POST)
    public RestResponse findByPage(@RequestBody QueryStation queryStation) {
        PageVO pageVO = stationService.getStationList(queryStation);
        return RestResponse.single(pageVO);
    }
}