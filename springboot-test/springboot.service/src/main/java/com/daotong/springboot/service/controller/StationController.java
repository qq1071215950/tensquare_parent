package com.daotong.springboot.service.controller;

import com.daotong.springboot.service.base.RestResponse;
import com.daotong.springboot.service.domain.dto.StationDTO;
import com.daotong.springboot.service.domain.interfaces.StationService;
import com.daotong.springboot.service.domain.vo.StationVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zdh 2019/12/6 10:52
 */
@ApiModel(value = "控制层")
@RestController
@RequestMapping("/station")
public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping("/save")
    @ApiOperation(httpMethod = "post", value = "添加站点信息", code = 200, notes = "返回数据为受影响的行数")
    public RestResponse saveStation(@RequestBody StationDTO stationDTO) {
        int i = stationService.saveStation(stationDTO);
        return RestResponse.single(i);
    }

    @PostMapping("/update")
    @ApiOperation(httpMethod = "post", value = "更新站点信息", notes = "返回数据为受影响的行数")
    public RestResponse updateStation(@RequestBody StationDTO stationDTO) {
        int i = stationService.updateStation(stationDTO);
        return RestResponse.single(i);
    }

    @GetMapping("/remove")
    @ApiOperation(httpMethod = "get", value = "删除站点信息", notes = "返回数据为受影响的行数")
    public RestResponse removeStation(@ApiParam(name = "stationId", value = "站点id", required = true)
                                      @RequestParam("id") Integer id) {
        int i = stationService.removeStation(id);
        return RestResponse.single(i);
    }

    @PostMapping("/get_by_page")
    @ApiOperation(httpMethod = "post", value = "分页查询站点信息", notes = "分页结果")
    public RestResponse findByPage(@RequestBody StationDTO stationDTO) {
        List<StationVO> stationList = stationService.getStationList(stationDTO);
        return RestResponse.single(stationList);
    }

    @GetMapping("/get_by_load_no")
    public RestResponse getListByLoadingNo(@ApiParam(name = "loadingNo", value = "运单号", required = true)
                                               @RequestParam(value = "loadingNo") String loadingNo) {
        List<StationVO> byLoadingNo = stationService.getByLoadingNo(loadingNo);
        return RestResponse.single(byLoadingNo);
    }
}