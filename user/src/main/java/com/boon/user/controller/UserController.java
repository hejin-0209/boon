package com.boon.user.controller;

import com.boon.pojo.User;
import com.boon.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "用户的控制器")
public class  UserController {

    @Autowired
    private UserService userService;

    /*全查*/
    @GetMapping("findAll")
    @ApiOperation(value = "全查所有的用户")
    public List<User> findAll(){
        return userService.findAll();
    }

    /*增加用户*/
    @PostMapping("addUser")
    @ApiOperation(value = "添加一个用户",notes = "用户的信息可由表导入，也可以在后台管理中输入")
    public boolean addUser(@RequestBody User user){
        System.out.println("需要增加的用户是:"+user);
        return userService.addUser(user);
    }

    /*根据学号查询用户*/
    @PostMapping("findBySno/{sno}")
    @ApiOperation(value = "根据用户的学号来查询用户的信息",notes = "用户的Sno由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "用户的学号",
            required = true ,dataType = "String")
    public User findBySno(@PathVariable String sno){
        System.out.println("传进来的学号是:"+sno);
        return userService.findBySno(sno);
    }

    /*删除用户*/
    @DeleteMapping("deleteBySno/{sno}")
    @ApiOperation(value = "根据学号删除一个用户", notes = "用户的学号由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "用户的学号",
            required = true ,dataType = "String")
    public boolean deleteBySno(@PathVariable String sno){

        return userService.deleteBySno(sno);
    }

    /*修改用户信息*/
    @PostMapping("update")
    @ApiOperation(value = "更新一个用户的信息",notes = "根据输入的内容来更新用户，在更新之前，需要先将用户查询出来")
    public boolean updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }
}
