package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.ICapacityService;
import com.boon.admin.service.IRewardService;
import com.boon.pojo.Capacity;
import com.boon.pojo.Rewards;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class CapacityController {

    @Autowired
    private ICapacityService capacityService;

    @Autowired
    private IRewardService rewardService;

    // 新增个人能力
    @LogAnnotation
    @ApiOperation("新增个人能力")
    @PostMapping("addCapacity")
    @RequiresPermissions("/capacity/addCapacity")
    public boolean addCapacity(@RequestBody Capacity capacity){
        return capacityService.addCapacity(capacity);
    }

    // 根据sno来查询个人能力
    @GetMapping("findBySno/{sno}")
    public Capacity findBySno(@PathVariable String sno){
        return capacityService.findBySno(sno);
    }

    // 将某个同学的个人能力的分查询出来，并折算好
    @GetMapping("convert/{sno}")
    public Double convert(@PathVariable String sno){
        if(rewardService.findFinalValue(sno,13) == null){
            return 6.0;
        }
        return capacityService.convert(sno);
    }

    // 更新个人能力
    @LogAnnotation
    @ApiOperation("更新个人能力")
    @PostMapping("update")
    @RequiresPermissions("/capacity/update")
    public boolean update(@RequestBody Capacity capacity){
        return capacityService.update(capacity);
    }

    // 查询所有的个人能力
    @GetMapping("findCapacity/{sno}")
    public List<Capacity> findCapacity(@PathVariable(value = "sno") String sno){
        List<Capacity> capacitys = capacityService.findCapacity(sno);
        for (Capacity capacity : capacitys) {
            Rewards finalValue = rewardService.findFinalValue(capacity.getSno(), 13);
            if (finalValue == null){
                capacity.setFinalRewards(0);
            }else{
                capacity.setFinalRewards(finalValue.getFinalValue());
            }
        }

        return capacitys;
    }

    // 删除个人能力
    @LogAnnotation
    @ApiOperation("删除个人能力")
    @DeleteMapping("delete/{sno}")
    @RequiresPermissions("/capacity/delete")
    public boolean delete(@PathVariable(value = "sno") String sno){
        return capacityService.delete(sno);
    }

    // 批量删除
    @LogAnnotation
    @ApiOperation("批量删除个人能力")
    @DeleteMapping("delBatch/{snos}")
    @RequiresPermissions("/capacity/delBatch")
    public boolean delBatch(@PathVariable(value = "snos") String[] snos){
        int i = 0;
        for (String sno : snos) {
            boolean b = capacityService.delete(sno);
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
