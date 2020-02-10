package com.boon.admin.controller;

import com.boon.admin.service.IUserService;
import com.boon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  用户的控制层
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    /*全查*/
    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /*增加用户*/
    @PostMapping("addUser")
    public boolean addUser(@RequestBody User user){
        System.out.println("需要增加的用户是:"+user);
        return userService.addUser(user);
    }

    /*根据学号查询用户*/
    @GetMapping("findBySno/{sno}")
    public User findBySno(@PathVariable String sno){
        System.out.println("传进来的学号是:"+sno);
        return userService.findBySno(sno);
    }

    /*删除用户*/
    @DeleteMapping("deleteBySno/{sno}")
    public boolean deleteBySno(@PathVariable String sno){

        return userService.deleteBySno(sno);
    }

    /*修改用户信息*/
    @PostMapping("update")
    public boolean updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }
}
