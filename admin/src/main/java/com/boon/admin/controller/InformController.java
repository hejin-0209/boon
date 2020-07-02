package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.IInformService;
import com.boon.pojo.Inform;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class InformController {

    @Autowired
    private IInformService informService;

    // 增加通知
    @LogAnnotation
    @ApiOperation("新增通知")
    @PostMapping("addInform")
    @RequiresPermissions("/inform/addInform")
    public boolean addInform(@RequestBody Inform inform){
        return informService.addInform(inform);
    }

    // 通过id查询通知
    @GetMapping("findById/{id}")
    public Inform findById(@PathVariable Integer id){
        return informService.findById(id);
    }

    // 查询所有的通知
    @GetMapping("findAll/{page}/{sno}/{title}/{startTime}/{endTime}")
    public PageInfo<Inform> findAll(@PathVariable("page") String page, @PathVariable("sno") String sno, @PathVariable("title") String title,
                                    @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime){
        return informService.findAll(page,sno,title,startTime,endTime);
    }

    // 通过管理员的学号来查询通知
    @GetMapping("findBySno/{userSno}")
    public List<Inform> findBySno(@PathVariable String userSno){
        return informService.findBySno(userSno);
    }

    // 更新通知
    @LogAnnotation
    @ApiOperation("更新通知")
    @PostMapping("update")
    @RequiresPermissions("/inform/update")
    public boolean update(@RequestBody Inform inform){
        return informService.update(inform);
    }

    // 删除通知
    @LogAnnotation
    @ApiOperation("删除通知")
    @GetMapping("delete/{id}")
    @RequiresPermissions("/inform/delete")
    public boolean delete(@PathVariable Integer id){
        return informService.delete(id);
    }

    // 获取通知的数量
    @GetMapping("findCount")
    public Integer findCount(){
        return informService.findCount();
    }

    // 批量删除
    @LogAnnotation
    @ApiOperation("批量删除通知")
    @DeleteMapping("delBatch/{ids}")
    @RequiresPermissions("/inform/delBatch")
    public boolean delBatch(@PathVariable("ids") Integer[] ids){
        int i = 0;
        for (Integer id : ids) {
            Inform inform = informService.findById(id);
            inform.setDel(1);
            boolean b = informService.update(inform);
            if(b){
                i++;
            }
        }
        if(i == ids.length){
            return true;
        }
        return false;
    }
}
