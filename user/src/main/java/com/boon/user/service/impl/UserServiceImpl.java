package com.boon.user.service.impl;

import com.boon.pojo.User;
import com.boon.user.mapper.UserMapper;
import com.boon.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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

    /*查询所有用户*/
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /*增加用户*/
    @Override
    public boolean addUser(User user) {
        user.setPassword(user.getSno().substring(4));
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
}
