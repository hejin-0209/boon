package com.boon.class_fee.controller;

import com.boon.class_fee.service.FeeService;
import com.boon.pojo.ClassFee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("Fee")
@Api(value = "班费的接口")
public class FeeController {

    @Autowired
    private FeeService feeService;

    //增加班费的管理
    @PostMapping("addFee")
    @ApiOperation(value = "增加帮费的管理" , notes = "需要提供一个ClassFee类的对象")
    public boolean addFee(ClassFee fee){
        return feeService.addFee(fee);
    }

    //查询班费还有多少
    @GetMapping("findMoney")
    @ApiOperation(value = "查询剩余的班费" , notes = "直接调用这个接口即可查询剩余逇班费")
    public double findMoney(){
        return feeService.findMoney();
    }

    // 班费管理的更新
    @PostMapping("updateFee")
    @ApiOperation(value = "班费管理的更新" , notes = "需要提供一个ClassFee类的对象")
    public boolean updateFee(ClassFee fee){
        return feeService.updateFee(fee);
    }

    // 根据id查询班费管理
    @PostMapping("findById/{id]")
    @ApiOperation(value = "根据id来查询班费管理" ,notes = "需要在前台输入所需要查询的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "班费的id",
            required = true ,dataType = "int")
    public ClassFee findById(@PathVariable int id){
        return feeService.findById(id);
    }

    // 根据学号来查询所管理的班费
    @PostMapping("findBySno/{sno}")
    @ApiOperation(value = "根据学号来查询所管理的班费" ,notes = "需要提供管理者的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "管理者的学号",
            required = true ,dataType = "String")
    public List<ClassFee> findBySno(@PathVariable String sno){
        return feeService.findBySno(sno);
    }
}
