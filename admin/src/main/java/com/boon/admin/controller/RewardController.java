package com.boon.admin.controller;

import com.boon.admin.service.IRewardService;
import com.boon.pojo.Rewards;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的控制层
 */
@RestController
@RequestMapping("reward")
public class RewardController {

    @Autowired
    private IRewardService rewardService;

    // 新增一个奖惩
    @PostMapping("addReward")
    public boolean addReward(@RequestBody Rewards rewards){
        return rewardService.addReward(rewards);
    }

    // 查询某位同学的最后一次奖惩情况
    @GetMapping("findFinalValue/{sno}/{typeId}")
    public Rewards findFinalValue(@PathVariable String sno , @PathVariable Integer typeId){
        return rewardService.findFinalValue(sno,typeId);
    }

    // 查询一位同学的奖惩情况
    @GetMapping("findBySno/{sno}")
    public List<Rewards> findBySno(@PathVariable String sno){
        return rewardService.findBySno(sno);
    }

    // 查询某一类型的所有的奖惩情况
    @GetMapping("findByTypeId/{typeId}")
    public List<Rewards> findByTypeId(@PathVariable Integer typeId){
        return rewardService.findByTypeId(typeId);
    }

    // 更新奖惩情况
    @PostMapping("update")
    public boolean update(@RequestBody Rewards rewards){
        return rewardService.update(rewards);
    }

    // 根据id查找奖惩情况
    @GetMapping("findById/{id}")
    public Rewards findById(@PathVariable Integer id){
        return rewardService.findById(id);
    }

    // 查询所有的奖惩情况
    @GetMapping("findRewards/{page}/{sno}/{typeId}/{startTime}/{endTime}")
    public PageInfo<Rewards> findRewards(@PathVariable(value = "page") String page , @PathVariable(value = "sno") String sno , @PathVariable(value = "typeId") String typeId,
                                         @PathVariable(value = "startTime") String  startTime , @PathVariable(value = "endTime") String  endTime){
        return rewardService.findRewards(page,sno,typeId,startTime,endTime);
    }
}
