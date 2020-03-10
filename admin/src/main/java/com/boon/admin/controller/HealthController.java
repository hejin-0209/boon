package com.boon.admin.controller;

import com.boon.admin.service.IHealthService;
import com.boon.admin.service.IRewardService;
import com.boon.pojo.Health;
import com.boon.pojo.Rewards;
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
public class HealthController {

    @Autowired
    private IHealthService healthService;

    @Autowired
    private IRewardService rewardService;

    // 新增卫生体育
    @PostMapping("addHealth")
    public boolean addHealth(@RequestBody Health health){
        return healthService.addHealth(health);
    }

    // 根据sno来查询卫生体育
    @GetMapping("findBySno/{sno}")
    public Health findBySno(@PathVariable String sno){
        return healthService.findBySno(sno);
    }

    // 将某个同学的卫生体育的分查询出来，并折算好
    @GetMapping("convert/{sno}")
    public Double convert(@PathVariable String sno){
        return healthService.convert(sno);
    }

    // 更新卫生体育
    @PostMapping("update")
    public boolean update(@RequestBody Health health){
        return healthService.update(health);
    }

    // 查询所有的卫生体育
    @GetMapping("findHealth/{sno}")
    public List<Health> findHealth(@PathVariable(value = "sno") String sno){
        List<Health> healths = healthService.findHealth(sno);
        for (Health health : healths) {
            Rewards finalValue = rewardService.findFinalValue(health.getSno(), 7);
            if (finalValue == null){
                health.setFinalRewards(0);
            }else{
                health.setFinalRewards(finalValue.getFinalValue());
            }
        }

        return healths;
    }

    // 删除卫生体育
    @DeleteMapping("delete/{sno}")
    public boolean delete(@PathVariable(value = "sno") String sno){
        return healthService.delete(sno);
    }

    // 批量删除
    @DeleteMapping("delBatch/{snos}")
    public boolean delBatch(@PathVariable(value = "snos") String[] snos){
        int i = 0;
        for (String sno : snos) {
            boolean b = healthService.delete(sno);
            if(b){
                i++;
            }
        }
        if(i == snos.length){
            return true;
        }
        return false;
    }

}
