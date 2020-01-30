package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Moral;
import com.boon.reward_and_punishment.service.MoralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "思想品德的接口")
public class MoralController {

    @Autowired
    private MoralService moralService;

    // 新增思想品德
    @PostMapping("addMoral")
    @ApiOperation(value = "新增思想品德" , notes = "需要提供思想品德的数据")
    private boolean addMoral(@RequestBody Moral moral){
        return moralService.addMoral(moral);
    }

    // 根据sno来查询思想品德
    @PostMapping("findBySno/{sno}")
    @ApiOperation(value = "根据sno来查询思想品德" ,notes = "需要提供思想品德中的学生的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Moral findBySno(@PathVariable String sno){
        return moralService.findBySno(sno);
    }

    // 将某个同学的思想品德的分查询出来，并折算好
    @PostMapping("convert/{sno}")
    @ApiOperation(value = "将某个同学的思想品德分折算出来" , notes = "需要提供这位同学的学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "string")
    public Double convert(@PathVariable String sno){
        return moralService.convert(sno);
    }

    // 更新思想品德
    @PostMapping("update")
    @ApiOperation(value = "更新思想品德" , notes = "需要将要更新的信息再前台输入")
    public boolean update(@RequestBody Moral moral){
        return moralService.update(moral);
    }

    // 查询所有的思想品德
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有的思想品德" , notes = "直接调用接口即可")
    public List<Moral> findAll(){
        return moralService.findAll();
    }
}
