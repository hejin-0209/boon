package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.ITypeService;
import com.boon.pojo.Type;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class TypeController {

    @Autowired
    private ITypeService typeService;

    // 新增类型
    @LogAnnotation
    @ApiOperation("新增类型")
    @PostMapping("addType")
    @RequiresPermissions("/type/addType")
    public boolean addType(@RequestBody Type type){
        return typeService.addType(type);
    }

    // 根据id查询类型
    @GetMapping("findById/{id}")
    public Type findById(@PathVariable int id){
        return typeService.findById(id);
    }

    // 查询所有的类型
    @GetMapping("findAll")
    public List<Type> findAll(){
        return typeService.findAll();
    }

    // 根据父类id查询类型
    @GetMapping("findParentId/{parentId}")
    public List<Type> findParentId(@PathVariable Integer parentId){
        return typeService.findParentId(parentId);
    }

    // 更新类型的信息
    @LogAnnotation
    @ApiOperation("更新类型")
    @PostMapping("update")
    @RequiresPermissions("/type/update")
    public boolean update(@RequestBody Type type){
        return typeService.update(type);
    }

    // 删除类型
    @LogAnnotation
    @ApiOperation("删除类型")
    @DeleteMapping("delete/{id}")
    @RequiresPermissions("/type/delte")
    public boolean delete(@PathVariable Integer id){
        return typeService.delete(id);
    }

    // 批量删除
    @LogAnnotation
    @ApiOperation("批量删除类型S")
    @DeleteMapping("delBatch/{ids}")
    @RequiresPermissions("/type/delBatch")
    public boolean delBatch(@PathVariable(value = "ids") int[] ids){
        return typeService.delBatch(ids);
    }
}
