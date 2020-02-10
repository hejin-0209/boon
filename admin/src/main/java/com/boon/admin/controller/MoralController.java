package com.boon.admin.controller;

import com.boon.admin.service.IMoralService;
import com.boon.pojo.Moral;
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

    // 新增思想品德
    @PostMapping("addMoral")
    private boolean addMoral(@RequestBody Moral moral){
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
        return moralService.convert(sno);
    }

    // 更新思想品德
    @PostMapping("update")
    public boolean update(@RequestBody Moral moral){
        return moralService.update(moral);
    }

    // 查询所有的思想品德
    @GetMapping("findAll")
    public List<Moral> findAll(){
        return moralService.findAll();
    }
}
