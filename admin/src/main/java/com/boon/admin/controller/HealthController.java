package com.boon.admin.controller;

import com.boon.admin.service.IHealthService;
import com.boon.pojo.Health;
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
    @GetMapping("findAll")
    public List<Health> findAll(){
        return healthService.findAll();
    }


}
