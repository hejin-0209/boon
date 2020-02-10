package com.boon.admin.controller;

import com.boon.admin.service.IFeeService;
import com.boon.pojo.ClassFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的控制层
 */
@RestController
@RequestMapping("fee")
public class FeeController {

    @Autowired
    private IFeeService feeService;

    //增加班费的管理
    @PostMapping("addFee")
    public boolean addFee(ClassFee fee){
        return feeService.addFee(fee);
    }

    //查询班费还有多少
    @GetMapping("findMoney")
    public double findMoney(){
        return feeService.findMoney();
    }

    // 班费管理的更新
    @PostMapping("updateFee")
    public boolean updateFee(ClassFee fee){
        return feeService.updateFee(fee);
    }

    // 根据id查询班费管理
    @GetMapping("findById/{id]")
    public ClassFee findById(@PathVariable int id){
        return feeService.findById(id);
    }

    // 根据学号来查询所管理的班费
    @GetMapping("findBySno/{sno}")
    public List<ClassFee> findBySno(@PathVariable String sno){
        return feeService.findBySno(sno);
    }
}