package com.boon.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.common.enums.ResultStatusCode;
import com.boon.admin.common.vo.Result;
import com.boon.admin.service.IUserService;
import com.boon.admin.service.TokenManager;
import com.boon.admin.utils.UserUtil;
import com.boon.pojo.User;
import com.boon.user.result.JsonResult;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
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

    @Autowired
    private TokenManager tokenManager;

    /*全查*/
    @GetMapping("findAll")
    public Result findAll(){
        List<User> list = userService.findAll();
        if(list.size()!=0){
            return new Result(ResultStatusCode.OK,list);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);
    }

    /*增加用户*/
    @PostMapping("addUser")
    public Result addUser(@RequestBody User user){
        System.out.println("需要增加的用户是:"+user);
        Boolean b = userService.addUser(user);
        if(b){
            return new Result(ResultStatusCode.OK,b);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);
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

    /*查询用户数量*/
    @GetMapping("findCount")
    public Result findCount(){
        Integer count = userService.findCount();
        if(count!=null){
            return new Result(ResultStatusCode.OK,count);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR,0);
    }

    /*修改用户状态*/
    @PostMapping("changeState/{sno}")
    public boolean changeState(@PathVariable(value = "sno") String sno){
        return userService.changeState(sno);
    }

    /*批量删除数据*/
    @DeleteMapping("delBatch/{snos}")
    public boolean delBatch(@PathVariable String[] snos){
        return userService.delBatch(snos);
    }

    /* 全查用户，分页 */
    @GetMapping("findUser")
    public JsonResult findUser(@RequestParam(value = "page") int page,@RequestParam(value = "limit") int limit){
        return userService.findUser(page,limit);
    }

    /* 查询已删除的用户 */
    @GetMapping("findDelete")
    public List<User> findDelete(){
        return userService.findDelete();
    }

    /* 修改删除状态 */
    @PostMapping("changeDel/{sno}")
    public boolean changeDel(@PathVariable String sno){
        return userService.changeDel(sno);
    }

    /* 批量恢复删除 */
    @PostMapping("restoreBatch/{snos}")
    public boolean restoreBatch(@PathVariable String[] snos){
        return userService.restoreBatch(snos);
    }

    @LogAnnotation
    @ApiOperation(value = "Restful方式登陆,前后端分离时登录接口")
    @PostMapping("login")
    public Result restfulLogin(@RequestBody User user) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getSno(), user.getPassword());
        System.out.println(usernamePasswordToken);
        try {
            //登录不在该处处理，交由shiro处理
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);

            if (subject.isAuthenticated()) {
                JSON json = new JSONObject();
                ((JSONObject) json).put("token", tokenManager.saveToken(usernamePasswordToken));

                return new Result(ResultStatusCode.OK, json);
            }else{
                return new Result(ResultStatusCode.SHIRO_ERROR);
            }
        }catch (IncorrectCredentialsException | UnknownAccountException e){
            e.printStackTrace();
            return new Result(ResultStatusCode.NOT_EXIST_USER_OR_ERROR_PWD);
        }catch (LockedAccountException e){
            return new Result(ResultStatusCode.USER_FROZEN);
        }catch (Exception e){
            return new Result(ResultStatusCode.SYSTEM_ERR);
        }

    }

    @ApiOperation(value = "当前登录用户")
    @GetMapping("loginUser")
    public User getLoginInfo() {
        return UserUtil.getCurrentUser();
    }

//    /**
//     * 退出登录
//     * @return
//     */
//    @GetMapping("logout")
//    public Result logout(){
//        SecurityUtils.getSubject().logout();
//        return new Result(ResultStatusCode.OK);
//    }

}
