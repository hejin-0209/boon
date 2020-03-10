package com.boon.user.controller;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.user.service.RightService;
import com.boon.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleService roleService;

    @GetMapping("findRight")
    public List<Right> findRight(){
        return rightService.findAll();
    }

    @GetMapping("findRole")
    public List<Role> findRole(){
        return roleService.findAll();
    }


}
