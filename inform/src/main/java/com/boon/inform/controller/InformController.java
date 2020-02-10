package com.boon.inform.controller;

import com.boon.inform.service.InformService;
import com.boon.pojo.Inform;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的控制层
 */
@RestController
@RequestMapping("inform")
@Api(value = "通知的接口")
public class InformController {

    @Autowired
    private InformService informService;

    // 增加通知
    @PostMapping("addInform")
    @ApiOperation(value = "新增通知" , notes = "通知的信息需要在前台输入")
    public boolean addInform(@RequestBody Inform inform){
        return informService.addInform(inform);
    }

    // 通过id查询通知
    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据id查找一个通知" , notes = "需要提供一个通知的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "通知的id",
            required = true ,dataType = "int")
    public Inform findById(@PathVariable Integer id){
        return informService.findById(id);
    }

    // 查询所有的通知
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有的通知" , notes = "直接调用接口即可使用")
    public List<Inform> findAll(){
        return informService.findAll();
    }

    // 通过管理员的学号来查询通知
    @GetMapping("findBySno/{userSno}")
    @ApiOperation(value = "通过管理员的学号来查询id" ,notes = "需要提供管理员的学号")
    @ApiImplicitParam(paramType = "path" , name = "userSno" ,value = "管理员的学号",
            required = true ,dataType = "String")
    public List<Inform> findBySno(@PathVariable String userSno){
        return informService.findBySno(userSno);
    }

    // 更新通知
    @PostMapping("update")
    @ApiOperation(value = "更新通知" , notes = "需要更新的内容需要在前台输入")
    public boolean update(@RequestBody Inform inform){
        return informService.update(inform);
    }

    // 删除通知
    @PostMapping("delete/{id}")
    @ApiOperation(value = "删除一个通知" , notes = "不是真正的删除，而是将Del字段的值改为1，需要提供通知的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "通知的id",
            required = true ,dataType = "int")
    public boolean delete(@PathVariable Integer id){
        return informService.delete(id);
    }
}
