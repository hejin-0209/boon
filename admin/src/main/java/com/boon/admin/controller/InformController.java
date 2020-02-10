package com.boon.admin.controller;

import com.boon.admin.service.IInformService;
import com.boon.pojo.Inform;
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
    @PostMapping("addInform")
    public boolean addInform(@RequestBody Inform inform){
        return informService.addInform(inform);
    }

    // 通过id查询通知
    @GetMapping("findById/{id}")
    public Inform findById(@PathVariable Integer id){
        return informService.findById(id);
    }

    // 查询所有的通知
    @GetMapping("findAll")
    public List<Inform> findAll(){
        return informService.findAll();
    }

    // 通过管理员的学号来查询通知
    @GetMapping("findBySno/{userSno}")
    public List<Inform> findBySno(@PathVariable String userSno){
        return informService.findBySno(userSno);
    }

    // 更新通知
    @PostMapping("update")
    public boolean update(@RequestBody Inform inform){
        return informService.update(inform);
    }

    // 删除通知
    @GetMapping("delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return informService.delete(id);
    }
}
