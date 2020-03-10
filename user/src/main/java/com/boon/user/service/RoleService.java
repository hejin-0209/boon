package com.boon.user.service;

import com.boon.pojo.Role;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
public interface RoleService {



    Set<String> findRoleNameByUserSno(String userSno);

    List<Role> findAll();

}


