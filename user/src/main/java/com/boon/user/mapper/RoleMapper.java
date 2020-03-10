package com.boon.user.mapper;

import com.boon.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Mapper
public interface RoleMapper {
    Set<String> findRoleNameByUserSno(String userSno);

    List<Role> findAll();

}
