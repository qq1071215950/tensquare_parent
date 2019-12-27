package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiange
 * @version 1.0
 * @date 2019/12/26 17:26
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String id){
        return new Result(true, StatusCode.OK,"查询成功",labelService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result update(@PathVariable("labelId") String id, @RequestBody Label label){
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable("labelId") String id){
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK,"删除成功",null);
    }

}
