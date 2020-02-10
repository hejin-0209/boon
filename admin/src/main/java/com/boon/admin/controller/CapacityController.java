package com.boon.admin.controller;

import com.boon.admin.service.ICapacityService;
import com.boon.pojo.Capacity;
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

    // 新增个人能力
    @PostMapping("addCapacity")
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
        return capacityService.convert(sno);
    }

    // 更新个人能力
    @PostMapping("update")
    public boolean update(@RequestBody Capacity capacity){
        return capacityService.update(capacity);
    }

    // 查询所有的个人能力
    @GetMapping("findAll")
    public List<Capacity> findAll(){
        return capacityService.findAll();
    }
}
