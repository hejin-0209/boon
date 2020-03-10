package com.boon.admin.service;

import com.boon.pojo.User;
import com.boon.user.result.JsonResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@FeignClient(value = "boon-zuul")
public interface IUserService {

    /**
     * 全查
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/findAll",method = RequestMethod.GET)
    List<User> findAll();

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/addUser",method = RequestMethod.POST)
    boolean addUser(@RequestBody User user);

    /**
     * 根据学号查询用户
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/findBySno/{sno}",method = RequestMethod.GET)
    User findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/update",method = RequestMethod.POST)
    boolean updateUser(@RequestBody User user);

    /**
     * 删除用户
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/deleteBySno/{sno}" ,method = RequestMethod.DELETE)
    boolean deleteBySno(@PathVariable(value = "sno") String sno);

    /**
     * 获取用户数量
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/findCount",method = RequestMethod.GET)
    Integer findCount();

    /**
     * 改变用户状态
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/changeState/{sno}",method = RequestMethod.POST)
    boolean changeState(@PathVariable(value = "sno") String sno);

    /**
     * 批量删除
     * @param snos
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/delBatch/{snos}",method = RequestMethod.DELETE)
    boolean delBatch(@PathVariable(value = "snos") String[] snos);

    /**
     * 查询用户，分页
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/findUser",method = RequestMethod.GET)
    JsonResult findUser(@RequestParam("page") int page, @RequestParam("limit") int limit);

    /**
     * 查看已删除的用户
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/findDelete",method = RequestMethod.GET)
    List<User> findDelete();

    /**
     * 修改删除状态
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/changeDel/{sno}",method = RequestMethod.POST)
    boolean changeDel(@PathVariable(value = "sno") String sno);

    /**
     * 批量恢复删除
     * @param snos
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/user/restoreBatch/{snos}",method = RequestMethod.POST)
    boolean restoreBatch(@PathVariable(value = "snos") String[] snos);

    /* 查找权限 */
    @RequestMapping(value = "boon/user-proxy/user/findRightByUserSno",method = RequestMethod.POST)
    Set<String> findRightByUserSno(@RequestBody User user);


    /* 查找角色 */
    @RequestMapping(value = "boon/user-proxy/user/findRoleNameByUserSno",method = RequestMethod.POST)
    Set<String> findRoleNameByUserSno(@RequestBody User user);


}
