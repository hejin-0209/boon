package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Health;
import com.boon.reward_and_punishment.service.HealthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的控制器
 */
@RestController
@RequestMapping("health")
@Api(value = "卫生体育的接口")
public class HealthController {

    @Autowired
    private HealthService healthService;

    // 新增卫生体育
    @PostMapping("addHealth")
    @ApiOperation(value = "新增卫生体育" , notes = "需要在前台输入卫生体育的数据")
    public boolean addHealth(@RequestBody Health health){
        return healthService.addHealth(health);
    }

    // 根据sno来查询卫生体育
    @GetMapping("findBySno/{sno}")
    @ApiOperation(value = "根据sno来查询卫生体育" ,notes = "需要提供卫生体育中的学生的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Health findBySno(@PathVariable String sno){
        return healthService.findBySno(sno);
    }

    // 将某个同学的卫生体育的分查询出来，并折算好
    @GetMapping("convert/{sno}")
    @ApiOperation(value = "将某个同学的卫生体育分折算出来" , notes = "需要提供这位同学的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Double convert(@PathVariable String sno){
        return healthService.convert(sno);
    }

    // 更新卫生体育
    @PostMapping("update")
    @ApiOperation(value = "更新卫生体育" , notes = "需要将要更新的信息再前台输入")
    public boolean update(@RequestBody Health health){
        return healthService.update(health);
    }

    // 查询所有的卫生体育
    @GetMapping("findHealth/{sno}")
    @ApiOperation(value = "查询所有的卫生体育" , notes = "条件查询需要输入学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public List<Health> findHealth(@PathVariable(value = "sno") String sno){
        if("null".equals(sno)){
            sno = null;
        }
        return healthService.findHealth(sno);
    }

    // 删除思想品德
    @DeleteMapping("delete/{sno}")
    public boolean delete(@PathVariable(value = "sno") String sno){
        return healthService.delete(sno);
    }

}
