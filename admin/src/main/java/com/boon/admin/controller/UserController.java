package com.boon.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.common.enums.ResultStatusCode;
import com.boon.admin.common.vo.Result;
import com.boon.admin.service.IUserService;
import com.boon.admin.service.LogService;
import com.boon.admin.service.TokenManager;
import com.boon.admin.utils.UserUtil;
import com.boon.pojo.Inform;
import com.boon.pojo.Logs;
import com.boon.pojo.User;
import com.boon.user.result.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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

    @Autowired
    private LogService logService;

    @Autowired
    private FastFileStorageClient storageClient;

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
    @LogAnnotation
    @ApiOperation("新增用户")
    @PostMapping("addUser")
    @RequiresPermissions("/user/addUser")
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
    @LogAnnotation
    @ApiOperation("删除用户")
    @DeleteMapping("deleteBySno/{sno}")
    @RequiresPermissions("/user/deleteBySno")
    public boolean deleteBySno(@PathVariable String sno){

        return userService.deleteBySno(sno);
    }

    /*修改用户信息*/
    @LogAnnotation
    @ApiOperation("修改用户信息")
    @PostMapping("update")
    @RequiresPermissions("/user/update")
    public boolean updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /*修改个人信息*/
    @PostMapping("updateSelf")
    public boolean updateSelf(@RequestBody User user){
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
    @LogAnnotation
    @ApiOperation("修改用户状态")
    @PostMapping("changeState/{sno}")
    @RequiresPermissions("/user/changeState")
    public boolean changeState(@PathVariable(value = "sno") String sno){
        return userService.changeState(sno);
    }

    /*批量删除数据*/
    @LogAnnotation
    @ApiOperation("批量删除用户")
    @DeleteMapping("delBatch/{snos}")
    @RequiresPermissions("/user/delBatch")
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
    @LogAnnotation
    @ApiOperation("修改用户删除状态")
    @PostMapping("changeDel/{sno}")
    @RequiresPermissions("/user/changeDel")
    public boolean changeDel(@PathVariable String sno){
        return userService.changeDel(sno);
    }

    /* 批量恢复删除 */
    @LogAnnotation
    @ApiOperation("批量恢复用户")
    @PostMapping("restoreBatch/{snos}")
    @RequiresPermissions("/user/restoreBatch")
    public boolean restoreBatch(@PathVariable String[] snos){
        return userService.restoreBatch(snos);
    }

    /*用户的登录*/
    @LogAnnotation
    @ApiOperation(value = "用户登录")
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
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return new Result(ResultStatusCode.NOT_EXIST_USER_OR_ERROR_PWD);
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return new Result(ResultStatusCode.USER_FROZEN);
        }catch (LockedAccountException e){
            return new Result(ResultStatusCode.USER_FROZEN);
        }catch (Exception e){
            return new Result(ResultStatusCode.SYSTEM_ERR);
        }

    }

    @ApiOperation(value = "获取当前登录用户")
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

    /*获取管理员的数量*/
    @ApiOperation(value = "获取管理员的数量")
    @GetMapping("findAdminCount")
    public Integer findAdminCount(){
        return userService.findAdminCount();
    }

    /*登录用户数*/
    @ApiOperation(value = "登录用户数")
    @GetMapping("loginCount")
    public Integer loginCount(){
        Collection<Session> list = ((DefaultSessionManager) ((DefaultSecurityManager) SecurityUtils .getSecurityManager()).getSessionManager()).getSessionDAO() .getActiveSessions();
        if (list.size() == 0){
            return 0;
        }
        return list.size();
    }

    /*当前用户的登录日志*/
    @GetMapping("userLogs/{sno}")
    public List<Logs> userLogs(@PathVariable("sno") String sno){
        return logService.userLogs(sno);
    }

    @GetMapping("toUpdate")
    @RequiresPermissions("/user/update")
    public void toUpdate(){

    }

    @GetMapping("isAdmin")
    @RequiresPermissions("/admin")
    public void isAdmin(){

    }

    /*查询所有的日志*/
    // 查询所有的通知
    @GetMapping("logs/{page}/{sno}/{module}/{startTime}/{endTime}")
    public PageInfo<Logs> findAll(@PathVariable("page") String page, @PathVariable("sno") String sno, @PathVariable("module") String module,
                                  @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime){
        System.out.println("传进来的数据：学号--" + sno + "标题--" + module + " 开始时间--" + startTime + " 结束时间--" + endTime);
        Timestamp sTime = null;
        Timestamp eTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("null".equals(sno)) {
            sno = null;
        }
        if ("null".equals(module)) {
            module = null;
        }
        try {
            if ("null".equals(startTime)) {
                sTime = null;
            } else {
                sTime = new Timestamp(sdf.parse(startTime).getTime());
            }
            if ("null".equals(endTime)) {
                eTime = null;
            } else {
                eTime = new Timestamp(sdf.parse(endTime).getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 分页，后端规定每页10条数据
        PageHelper.startPage(Integer.valueOf(page), 10);
        PageInfo<Logs> logs = new PageInfo<>(logService.findAll(sno,module, sTime, eTime));
        System.out.println("页面信息是：" + logs);
        return logs;
    }

    @PostMapping("bulkImport")
    @RequiresPermissions("/admin")
    public Result bulkImport(MultipartFile file) throws Exception{

//        System.out.println(file.getOriginalFilename());     // 文件名
//        System.out.println(file.getBytes());                // 字节
//        System.out.println(file.getContentType());          // 类别
//        System.out.println(file.getSize());                 // 大小
//        InputStream inputStream = file.getInputStream();    // 输入流
        Integer integer = userService.bulkImport(file.getOriginalFilename());
        if(integer == 1){
            return new Result(ResultStatusCode.OK);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);

    }

    @PostMapping("uploadPhoto")
    public Result uploadPhoto(MultipartFile file, ServletRequest request) throws Exception{
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String loginUser = httpServletRequest.getHeader("login_user");
        StringBuffer fDfsPath = new StringBuffer("http://39.108.98.95:8080/");
        StorePath storePath = this.storageClient.uploadFile(
                file.getInputStream(), file.getSize(), "jpg", null);
        System.out.println("带分组的路径："+storePath.getFullPath());
        fDfsPath.append(storePath.getFullPath());
        System.out.println("追加之后的路径为："+fDfsPath);
        System.out.println("需要修改的用户是："+loginUser);
        User user = new User();
        user.setPicture(fDfsPath.toString());
        user.setSno(loginUser);
        boolean b = userService.uploadPhoto(user);

        if(b){
            return new Result(ResultStatusCode.OK);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);
    }


}
