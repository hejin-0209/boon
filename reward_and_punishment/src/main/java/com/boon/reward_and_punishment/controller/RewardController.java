package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Rewards;
import com.boon.reward_and_punishment.service.RewardService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @GetMapping("findFinalValue/{sno}/{typeId}")
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
    @GetMapping("findBySno/{sno}")
    @ApiOperation(value = "查询一位同学的奖惩情况" ,notes = "需要提供学生的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public List<Rewards> findBySno(@PathVariable String sno){
        return rewardService.findBySno(sno);
    }

    // 查询某一类型的所有的奖惩情况
    @GetMapping("findByTypeId/{typeId}")
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
    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据id查找奖惩情况" ,notes = "需要提供奖惩的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "奖惩的id",
            required = true ,dataType = "int")
    public Rewards findById(@PathVariable Integer id){
        return rewardService.findById(id);
    }

    // 查询所有的奖惩情况
    @GetMapping("findRewards/{page}/{sno}/{typeId}/{startTime}/{endTime}")
    @ApiOperation(value = "查询所有的奖惩情况" ,notes = "条件查询需要输入学号")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path" , name = "paeg" ,value = "分页页码",
                    required = true ,dataType = "string"),
            @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
                    required = true ,dataType = "string"),
            @ApiImplicitParam(paramType = "path" , name = "typeId" ,value = "类型",
                    required = true ,dataType = "String"),
            @ApiImplicitParam(paramType = "path" , name = "startTime" ,value = "开始时间",
                    required = true ,dataType = "String"),
            @ApiImplicitParam(paramType = "path" , name = "endTime" ,value = "结束时间",
                    required = true ,dataType = "String")
    })
    public PageInfo<Rewards> findRewards(@PathVariable(value = "page")String page, @PathVariable(value = "sno") String sno , @PathVariable(value = "typeId") String typeId,
                                         @PathVariable(value = "startTime") String startTime , @PathVariable(value = "endTime") String endTime) {
        System.out.println("传进来的数据：学号--"+sno+" 类型--"+typeId+" 开始时间--"+startTime+" 结束时间--"+endTime);
        Integer tId = null;
        Timestamp sTime = null;
        Timestamp eTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if("null".equals(sno)){
            sno = null;
        }
        if("null".equals(typeId)){
            tId = null;
        }else{
            tId = Integer.valueOf(typeId);
        }
        try {
            if("null".equals(startTime)){
                sTime = null;
            }else {
                sTime = new Timestamp(sdf.parse(startTime).getTime());
            }
            if("null".equals(endTime)){
                eTime = null;
            }else{
                eTime = new Timestamp(sdf.parse(endTime).getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 分页，后端规定每页10条数据
        PageHelper.startPage(Integer.valueOf(page), 10);
        PageInfo<Rewards> info = new PageInfo<>(rewardService.findRewards(sno, tId, sTime, eTime));
        System.out.println("页面信息是："+info);
        return info;
    }
}
