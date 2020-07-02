package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.IMoralService;
import com.boon.admin.service.IRewardService;
import com.boon.pojo.Moral;
import com.boon.pojo.Rewards;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  思想品德的控制器
 */
@RestController
@RequestMapping("moral")
public class MoralController {

    @Autowired
    private IMoralService moralService;

    @Autowired
    private IRewardService rewardService;

    // 新增思想品德
    @LogAnnotation
    @ApiOperation("新增思想品德")
    @PostMapping("addMoral")
    @RequiresPermissions("/moral/addMoral")
    public boolean addMoral(@RequestBody Moral moral){
        return moralService.addMoral(moral);
    }

    // 根据sno来查询思想品德
    @GetMapping("findBySno/{sno}")
    public Moral findBySno(@PathVariable String sno){
        return moralService.findBySno(sno);
    }

    // 将某个同学的思想品德的分查询出来，并折算好
    @GetMapping("convert/{sno}")
    public Double convert(@PathVariable String sno){
        if(rewardService.findFinalValue(sno,1) == null){
            return 12.0;
        }
        return moralService.convert(sno);
    }

    // 更新思想品德
    @LogAnnotation
    @ApiOperation("更新思想品德")
    @PostMapping("update")
    @RequiresPermissions("/moral/update")
    public boolean update(@RequestBody Moral moral){
        return moralService.update(moral);
    }

    // 查询所有的思想品德
    @GetMapping("findMoral/{sno}")
    public List<Moral> findMoral(@PathVariable(value = "sno") String sno){

        List<Moral> morals = moralService.findMoral(sno);
        for (Moral moral : morals) {
            Rewards finalValue = rewardService.findFinalValue(moral.getSno(), 1);
            if (finalValue == null){
                moral.setFinalRewards(0);
            }else{
                moral.setFinalRewards(finalValue.getFinalValue());
            }
        }

        return morals;
    }

    // 删除思想品德
    @LogAnnotation
    @ApiOperation("删除思想品德")
    @DeleteMapping("delete/{sno}")
    @RequiresPermissions("/moral/delete")
    public boolean delete(@PathVariable(value = "sno") String sno){
        return moralService.delete(sno);
    }

    // 批量删除
    @LogAnnotation
    @ApiOperation("批量删除思想品德")
    @DeleteMapping("delBatch/{snos}")
    @RequiresPermissions("/moral/delBatch")
    public boolean delBatch(@PathVariable(value = "snos") String[] snos){
        int i = 0;
        for (String sno : snos) {
            boolean b = moralService.delete(sno);
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
