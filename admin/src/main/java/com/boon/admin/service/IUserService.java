package com.boon.admin.service;

import com.boon.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    @RequestMapping("boon/user-proxy/user/findAll")
    List<User> findAll();

    /**
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping("boon/user-proxy/user/addUser")
    boolean addUser(@RequestBody User user);

    /**
     * 根据学号查询用户
     * @param sno
     * @return
     */
    @RequestMapping("boon/user-proxy/user/findBySno/{sno}")
    User findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("boon/user-proxy/user/updateUser")
    boolean updateUser(@RequestBody User user);

    /**
     * 修改用户信息
     * @param sno
     * @return
     */
    @RequestMapping("boon/user-proxy/user/deleteBySno/{sno}")
    boolean deleteBySno(@PathVariable(value = "sno") String sno);

}
