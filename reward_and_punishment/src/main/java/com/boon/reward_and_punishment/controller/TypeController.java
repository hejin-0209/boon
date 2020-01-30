package com.boon.reward_and_punishment.controller;

import com.boon.pojo.Type;
import com.boon.reward_and_punishment.service.TypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  类型的控制层
 */
@RestController
@RequestMapping("type")
@Api(value = "类型的接口")
public class TypeController {

    @Autowired
    private TypeService typeService;

    // 新增类型
    @PostMapping("addType")
    @ApiOperation(value = "新增类型" , notes = "需要在前台输入类型的信息")
    public boolean addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    // 根据id查询类型
    @PostMapping("findById/{id}")
    @ApiOperation(value = "根据id查询类型" , notes = "需要提供类型的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "类型的id",
            required = true ,dataType = "int")
    public Type findById(@PathVariable int id){
        return typeService.findById(id);
    }

    // 查询所有的类型
    @GetMapping("findAll")
    @ApiOperation(value = "查询所有的类型" , notes = "直接调用接口即可")
    public List<Type> findAll(){
        return typeService.findAll();
    }

    // 根据父类id查询类型
    @PostMapping("findParentId/{parentId}")
    @ApiOperation(value = "根据父类id查询类型" ,notes = "需要提供父类的id")
    @ApiImplicitParam(paramType = "path" , name = "parentId" ,value = "父类的id",
            required = true ,dataType = "int")
    public List<Type> findParentId(@PathVariable Integer parentId){
        return typeService.findParentId(parentId);
    }

    // 更新类型的信息
    @PostMapping("update")
    @ApiOperation(value = "更新类型的信息" , notes = "需要提供类型的信息")
    public boolean update(@RequestBody Type type){
        return typeService.update(type);
    }

    // 删除类型
    @PostMapping("delete/{id}")
    @ApiOperation(value = "根据id删除类型" , notes = "需要提供类型的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "类型的id",
            required = true ,dataType = "int")
    public boolean delete(@PathVariable Integer id){
        return typeService.delete(id);
    }
}
