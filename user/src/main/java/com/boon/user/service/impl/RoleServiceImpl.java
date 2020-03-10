package com.boon.user.service.impl;

import com.boon.pojo.Role;
import com.boon.user.mapper.RoleMapper;
import com.boon.user.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleMapper roleMapper;

    @Override
    public Set<String> findRoleNameByUserSno(String userSno) {
        return roleMapper.findRoleNameByUserSno(userSno);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }
}
