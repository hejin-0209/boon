package com.boon.user.service.impl;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;
import com.boon.user.mapper.RoleMapper;
import com.boon.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<String> findRoleNameByUserSno(String userSno) {
        return roleMapper.findRoleNameByUserSno(userSno);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public boolean addRoleRight(Integer roleId, Integer rightId) {

        return roleMapper.addRoleRight(roleId,rightId);
    }

    @Override
    public List<RoleVo> findAdmin(String sno, String roleName, Timestamp sTime, Timestamp eTime) {
        String name = null;
        if(sno != null){
            if(sno.matches("^[\u4e00-\u9fa5]+$")){
                name = sno;
                sno = null;
            }
        }
        return roleMapper.findAdmin(sno,name,roleName,sTime,eTime);
    }

    @Override
    public boolean addAdmin(UserRole userRole) {
        UserRole userRole1 = roleMapper.findAdminBySno(userRole.getUserSno());
        System.out.println("我要修改的管理员是："+userRole1);
        if(userRole1 != null){
            userRole1.setRoleId(userRole.getRoleId());
            System.out.println("修改之后的管理员："+userRole1);
            boolean b = roleMapper.updateAdmin(userRole1);
            return b;
        }
        return false;
    }

    @Override
    public boolean roleIsExist(Integer roleId) {
        UserRole userRole = roleMapper.roleIsExist(roleId);
        if(userRole != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdmin(Integer id) {
        UserRole userRole = roleMapper.findAdminById(id);
        if(userRole != null){
            userRole.setRoleId(12);
            boolean b = roleMapper.updateAdmin(userRole);
            return b;
        }
        return false;
    }

    @Override
    public List<RoleDto> findRole(String roleName) {
        ArrayList<RoleDto> roleDtos = new ArrayList<>();
        List<Role> roles = roleMapper.findRoleByName(roleName);
        int i = 0;
        for (Role role : roles) {
            List<Right> rights = roleMapper.findRightByRoleName(null,role.getId());
            RoleDto roleDto = new RoleDto();
            roleDto.setRole(role);
            roleDto.setRights(rights);
            roleDtos.add(i,roleDto);
            i++;
        }

        return roleDtos;
    }

    @Override
    public boolean addRole(RoleDto roleDto) {
        boolean b = roleMapper.addRole(roleDto.getRole());
        String[] ids = roleDto.getIds();

        if (b){
            List<Role> roles = roleMapper.findRoleByName(roleDto.getRole().getName());
            int i = 0;
            for (Role role : roles) {
                for (String id : ids) {
                    boolean b1 = roleMapper.addRoleRight(role.getId(), Integer.valueOf(id));
                    if (b1){
                        i++;
                    }
                }
            }
            if(i == ids.length){
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean roleIsFind(Integer roleId, String name) {
        Role role = roleMapper.roleIsFind(roleId, name);
        if (role != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Right> findRightByRoleName(Integer roleId,String roleName) {
        return roleMapper.findRightByRoleName(roleName,roleId);
    }

    @Override
    public Role findRoles(Integer roleId) {
        return roleMapper.findRole(roleId);
    }

    @Override
    public boolean update(Role role) {
        return roleMapper.update(role);
    }
}
