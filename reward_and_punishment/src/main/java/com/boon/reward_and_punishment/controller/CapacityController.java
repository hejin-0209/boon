package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Capacity;
import com.boon.pojo.Health;
import com.boon.pojo.Rewards;
import com.boon.reward_and_punishment.service.CapacityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  个人能力的控制层
 */
@RestController
@RequestMapping("capacity")
@Api(value = "个人能力的接口")
public class CapacityController {

    @Autowired
    private CapacityService capacityService;

    // 新增个人能力
    @PostMapping("addCapacity")
    @ApiOperation(value = "新增个人能力" , notes = "需要在前台输入个人能力的数据")
    public boolean addCapacity(@RequestBody Capacity capacity){
        return capacityService.addCapacity(capacity);
    }

    // 根据sno来查询个人能力
    @GetMapping("findBySno/{sno}")
    @ApiOperation(value = "根据sno来查询个人能力" ,notes = "需要提供个人能力中的学生的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Capacity findBySno(@PathVariable String sno){
        return capacityService.findBySno(sno);
    }

    // 将某个同学的个人能力的分查询出来，并折算好
    @GetMapping("convert/{sno}")
    @ApiOperation(value = "将某个同学的个人能力分折算出来" , notes = "需要提供这位同学的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Double convert(@PathVariable String sno){
        return capacityService.convert(sno);
    }

    // 更新个人能力
    @PostMapping("update")
    @ApiOperation(value = "更新个人能力" , notes = "需要将要更新的信息再前台输入")
    public boolean update(@RequestBody Capacity capacity){
        return capacityService.update(capacity);
    }

    // 查询所有的个人能力
    @GetMapping("findCapacity/{sno}")
    @ApiOperation(value = "查询所有的个人能力" , notes = "条件查询需要输入学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public List<Capacity> findCapacity(@PathVariable(value = "sno") String sno){
        if("null".equals(sno)){
            sno = null;
        }
        return capacityService.findCapacity(sno);
    }

    // 删除思想品德
    @DeleteMapping("delete/{sno}")
    public boolean delete(@PathVariable(value = "sno") String sno){
        return capacityService.delete(sno);
    }


}
