package com.boon.user.service.impl;

import com.boon.pojo.User;
import com.boon.user.mapper.RightMapper;
import com.boon.user.result.JsonResult;
import org.apache.commons.lang3.StringUtils;
import com.boon.user.mapper.UserMapper;
import com.boon.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RightMapper rightMapper;

    /*查询所有用户*/
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /*增加用户*/
    @Override
    public boolean addUser(User user) {
        user.setPassword(user.getSno().substring(4));
        user.setGender("男");
        System.out.println("用户的密码是:"+user.getPassword());
        System.out.println("设置了密码的用户是:"+user);
        return userMapper.addUser(user);
    }

    @Override
    public User findBySno(String sno) {
        return userMapper.findBySno(sno);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean deleteBySno(String sno) {
        System.out.println("传进来的学号是:"+sno);
        User user = userMapper.findBySno(sno);
        System.out.println("查询出来的用户是:"+user);
        user.setDel(1);
        System.out.println("修改之后的用户是:"+user);
        return userMapper.updateUser(user);
    }

    @Override
    public Integer findCount() {
        return userMapper.findCount();
    }

    @Override
    public boolean changeState(String sno) {
        System.out.println("传进来的学号是："+sno);
        User user = userMapper.findBySno(sno);
        System.out.println(user);
        if(user.getState() == 1){
            //修改用户的状态为0；
            user.setState(0);
            System.out.println(user);
        }else{
            //修改用户的状态为1；
            user.setState(1);
            System.out.println(user);
        }
        boolean b = userMapper.updateUser(user);
        System.out.println(b);
        return b;
    }

    @Override
    public boolean delBatch(String[] snos) {
        int i = 0;
        for (String sno : snos) {
            User user = userMapper.findBySno(sno);
            user.setDel(1);
            boolean b = userMapper.updateUser(user);
            if(b){
                i++;
            }
        }
        if (i == snos.length){
            return true;
        }
        return false;
    }

    @Override
    public JsonResult findUser(int page, int limit) {
        PageHelper.startPage(page,limit);
        PageInfo<User> info = new PageInfo<>(userMapper.findAll());
        System.out.println("info；"+info);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(info.getList());
        jsonResult.setCode(0);
        jsonResult.setMsg("已经成功取到数据！");
        jsonResult.setCount(info.getTotal());
        return jsonResult;
    }

    @Override
    public List<User> findDelete() {
        return userMapper.findDelete();
    }

    @Override
    public boolean changeDel(String sno) {
        User user = userMapper.findBySno(sno);
        if(user.getDel() == 1){
            //将用户的删除状态改为0，表示已恢复删除。
            user.setDel(0);
        }

        return userMapper.updateUser(user);
    }

    @Override
    public boolean restoreBatch(String[] snos) {
        int i = 0;
        for (String sno : snos) {
            User user = userMapper.findBySno(sno);
            user.setDel(0);
            boolean b = userMapper.updateUser(user);
            if(b){
                i++;
            }
        }
        if (i == snos.length){
            return true;
        }
        return false;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public Set<String> findRightByUserSno(String userSno) {
        Set<String> permissions = rightMapper.findRightByUserSno(userSno);
        Set<String> result = new HashSet<>();
        for (String permission : permissions) {
            if (StringUtils.isBlank(permission)) {
                continue;
            }
            permission = StringUtils.trim(permission);
            result.addAll(Arrays.asList(permission.split("\\s*;\\s*")));
        }
        return result;
    }
}
