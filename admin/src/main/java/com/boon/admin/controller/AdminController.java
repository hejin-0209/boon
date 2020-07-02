package com.boon.admin.controller;

import com.boon.admin.common.enums.ResultStatusCode;
import com.boon.admin.common.vo.Result;
import com.boon.admin.service.IAdminService;
import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RightDto;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * author:       HeJin
 * Date:         2020/3/15
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    /**
     * 查询所有的管理员用户
     * @param page
     * @param sno
     * @param roleName
     * @param startTime
     * @param endTime
     * @return
     */
    @RequiresPermissions("/admin/all")
    @GetMapping("user/{page}/{sno}/{roleName}/{startTime}/{endTime}")
    public PageInfo<RoleVo> findAdmin(@PathVariable("page")String page, @PathVariable("sno")String sno, @PathVariable("roleName") String roleName,
                                      @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime){
        return adminService.findAdmin(page,sno,roleName,startTime,endTime);
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("toAdd")
    @RequiresPermissions("/admin/all")
    public void toAdd(){
    }

    /**
     * 给用户分配角色
     * @param userRole
     * @return
     */
    @RequiresPermissions("/admin/all")
    @PostMapping("addAdmin")
    public Result add(@RequestBody(required = false) UserRole userRole){
        System.out.println("传进来的用户角色是："+userRole);
        if (adminService.userNotExist(userRole)){
            return new Result(ResultStatusCode.USER_NOT_EXIST);
        }
        if(adminService.roleIsExist(userRole)){
            return new Result(ResultStatusCode.ROlE_EXIST);
        }
        boolean b = adminService.add(userRole);
        if(b){
            return new Result(ResultStatusCode.OK,b);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);
    }

    /**
     * 删除管理员就是将管理员的角色改为普通同学
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @RequiresPermissions("/admin/all")
    public boolean delete(@PathVariable Integer id){
        return adminService.delete(id);
    }

    /**
     * 查询角色
     * @return
     */
    @GetMapping("findRole")
    @RequiresPermissions("/admin/all")
    public List<Role> findRole(){
        return adminService.findRole();
    }

    /**
     * 查询角色，分页，增强
     * @param page
     * @param roleName
     * @return
     */
    @GetMapping("findRole/{page}/{roleName}")
    @RequiresPermissions("/admin/all")
    public PageInfo<RoleDto> findRole(@PathVariable("page")String page, @PathVariable("roleName")String roleName){
        return adminService.findRole(page,roleName);
    }

    /**
     * 删除角色就是将角色的删除状态改为1
     * @param id
     * @return
     */
    @RequestMapping("deleteRole/{id}")
    @RequiresPermissions("/admin/all")
    public boolean deleteRole(@PathVariable("id")Integer id){
        return adminService.deleteRole(id);
    }

    /**
     * 查询权限
     * @param parentId
     * @return
     */
    @GetMapping("findRight/{page}/{parentId}")
    @RequiresPermissions("/admin/all")
    public PageInfo<RightDto> findRight(@PathVariable("page")String page, @PathVariable("parentId") String parentId){
        return adminService.findRight(page,parentId);
    }

    /**
     * 增加角色
     * @param roleDto
     * @return
     */
    @PostMapping("addRole")
    @RequiresPermissions("/admin/all")
    public Result addRole(@RequestBody RoleDto roleDto){
        boolean b = adminService.roleIsFind(null, roleDto.getRole().getName());
        if (b){
            return new Result(ResultStatusCode.ROLENAME_EXIST);
        }
        boolean b1 = adminService.addRole(roleDto);
        if(b1){
            return new Result(ResultStatusCode.OK);
        }
        return new Result(ResultStatusCode.SYSTEM_ERR);
    }

    /**
     * 根据角色id或name查询权限
     * @param roleId
     * @param roleName
     * @return
     */
    @GetMapping("findRightByRoleName/{roleId}/{roleName}")
    @RequiresPermissions("/admin/all")
    public List<Right> findRightByRoleName(@PathVariable("roleId") String roleId, @PathVariable("roleName") String roleName){
        return adminService.findRightByRoleName(roleId,roleName);
    }

    /**
     * 查询权限
     * @param parentId
     * @return
     */
    @GetMapping("findRights/{roleId}/{parentId}")
    @RequiresPermissions("/admin/all")
    public List<RightDto> findRights(@PathVariable("roleId")String roleId, @PathVariable("parentId") String parentId){
        return adminService.findRights(roleId,parentId);
    }

    /**
     * 查询权限
     * @param page
     * @param parentId
     * @param name
     * @return
     */
    @GetMapping("findRights1/{page}/{parentId}/{name}")
    @RequiresPermissions("/admin/all")
    public PageInfo<Right> findRights(@PathVariable("page")String page,@PathVariable("parentId")String parentId,@PathVariable("name")String name){
       return adminService.findRights(page,parentId,name);
    }

}
