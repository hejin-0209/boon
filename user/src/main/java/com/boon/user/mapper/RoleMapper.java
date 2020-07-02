package com.boon.user.mapper;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
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

    boolean addRoleRight(@Param("roleId") Integer roleId,@Param("rightId") Integer rightId);

    List<RoleVo> findAdmin(@Param("sno") String sno,@Param("name") String name,@Param("roleName") String roleName,
                           @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    boolean addAdmin(UserRole userRole);

    UserRole roleIsExist(Integer roleId);

    boolean updateAdmin(UserRole userRole);

    UserRole findAdminById(Integer id);

    UserRole findAdminBySno(String sno);

    List<Right> findRightByRoleName(@Param("roleName") String roleName,@Param("roleId") Integer roleId);

    List<Role> findRoleByName(String roleName);

    boolean addRole(Role role);

    Role roleIsFind(@Param("roleId") Integer roleId,@Param("name") String name);

    Role findRole(Integer roleId);

    boolean update(Role role);

}
