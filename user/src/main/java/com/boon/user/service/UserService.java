package com.boon.user.service;

import com.boon.pojo.User;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
public interface UserService {

    List<User> findAll();

    boolean addUser(User user);

    User findBySno(String sno);

    boolean updateUser(User user);

    boolean deleteBySno(String sno);

}
