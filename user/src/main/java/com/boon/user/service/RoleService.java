package com.boon.user.service;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;

import java.sql.Timestamp;
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

    boolean addRoleRight(Integer roleId,Integer rightId);

    List<RoleVo> findAdmin(String sno, String roleName, Timestamp sTime, Timestamp eTime);

    boolean addAdmin(UserRole userRole);

    boolean roleIsExist(Integer roleId);

    boolean deleteAdmin(Integer id);

    List<RoleDto> findRole(String roleName);

    boolean addRole(RoleDto roleDto);

    boolean roleIsFind(Integer roleId,String name);

    List<Right> findRightByRoleName(Integer roleId,String roleName);

    Role findRoles(Integer roleId);

    boolean update(Role role);
}


