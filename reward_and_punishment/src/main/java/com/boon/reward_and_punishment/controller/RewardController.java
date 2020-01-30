package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Rewards;
import com.boon.reward_and_punishment.service.RewardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的控制层
 */
@RestController
@RequestMapping("reward")
@Api(value = "奖惩的接口")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    // 新增一个奖惩
    @PostMapping("addReward")
    @ApiOperation(value = "新增一个奖惩情况" , notes = "需要在前台输入奖惩的信息")
    public boolean addReward(@RequestBody Rewards rewards){
        return rewardService.addReward(rewards);
    }

    // 查询某位同学的最后一次奖惩情况
    @PostMapping("findFinalReward/{sno}/{typeId}")
    @ApiOperation(value = "查询某位同学的最后一次奖惩情况" ,notes = "需要提供者为同学的学号和需要查询的奖惩类型")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
                    required = true ,dataType = "string"),
            @ApiImplicitParam(paramType = "path" , name = "typeId" ,value = "类型的id",
                    required = true ,dataType = "int")
    })
    public Rewards findFinalValue(@PathVariable String sno , @PathVariable Integer typeId){
        return rewardService.findFinalValue(sno,typeId);
    }

    // 查询一位同学的奖惩情况
    @PostMapping("findBySno/{sno}")
    @ApiOperation(value = "查询一位同学的奖惩情况" ,notes = "需要提供学生的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public List<Rewards> findBySno(@PathVariable String sno){
        return rewardService.findBySno(sno);
    }

    // 查询某一类型的所有的奖惩情况
    @PostMapping("findByTypeId/{typeId}")
    @ApiOperation(value = "查询某一类型的所有的奖惩情况" , notes = "需要提供类型的id")
    @ApiImplicitParam(paramType = "path" , name = "typeId" ,value = "类型的id",
            required = true ,dataType = "int")
    public List<Rewards> findByTypeId(@PathVariable Integer typeId){
        return rewardService.findByTypeId(typeId);
    }

    // 更新奖惩情况
    @PostMapping("update")
    @ApiOperation(value = "更新奖惩情况" , notes = "需要在前台输入奖惩的更新信息")
    public boolean update(@RequestBody Rewards rewards){
        return rewardService.update(rewards);
    }

    // 根据id查找奖惩情况
    @PostMapping("findById/{id}")
    @ApiOperation(value = "根据id查找奖惩情况" ,notes = "需要提供奖惩的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "奖惩的id",
            required = true ,dataType = "int")
    public Rewards findById(@PathVariable Integer id){
        return rewardService.findById(id);
    }

    // 查询所有的奖惩情况
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有的奖惩情况" ,notes = "直接调用接口即可")
    public List<Rewards> findAll(){
        return rewardService.findAll();
    }
}
