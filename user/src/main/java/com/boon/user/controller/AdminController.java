package com.boon.user.controller;

import com.boon.pojo.*;
import com.boon.pojo.vo.RightDto;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;
import com.boon.user.service.RightService;
import com.boon.user.service.RoleService;
import com.boon.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("findRight/{page}/{parentId}")
    public PageInfo<RightDto> findRight(@PathVariable("page")String page, @PathVariable("parentId") String parentId){
        Integer pId = null;
        if ("null".equals(parentId)){
            pId = null;
        }else{
            pId = Integer.valueOf(parentId);
        }
        List<Right> parents = rightService.findAll(pId,null);
        List<RightDto> rightDtos = new ArrayList<>();
        int i = 0;
        for (Right parent : parents) {
            List<Right> childs = rightService.findAll(parent.getId(),null);
            RightDto rightDto = new RightDto();
            rightDto.setParent(parent);
            rightDto.setChilds(childs);
            rightDtos.add(i,rightDto);
            i++;
        }
        PageHelper.startPage(Integer.valueOf(page), 10);
        PageInfo<RightDto> rightDtoPageInfo = new PageInfo<>(rightDtos);
        return rightDtoPageInfo;
    }

    /**
     * 查询权限
     *
     * @param roleId
     * @param parentId
     * @return
     */
    @GetMapping("findRights/{roleId}/{parentId}")
    public List<RightDto> findRights(@PathVariable("roleId") String roleId, @PathVariable("parentId") String parentId){
        Integer rId = null;
        Integer pId = null;
        if(!"null".equals(roleId)){
           rId = Integer.valueOf(roleId);
        }
        if(!"null".equals(parentId)){
            pId = Integer.valueOf(parentId);
        }
        List<Right> parents = rightService.findRightByRoleId(rId,pId);
        List<RightDto> rightDtos = new ArrayList<>();
        int i = 0;
        for (Right parent : parents) {
            List<Right> childs = rightService.findRightByRoleId(rId,parent.getId());
            RightDto rightDto = new RightDto();
            rightDto.setParent(parent);
            rightDto.setChilds(childs);
            rightDtos.add(i,rightDto);
            i++;
        }

        return rightDtos;
    }

    @GetMapping("findRole")
    public List<Role> findRole(){
        return roleService.findAll();
    }

    /**
     * 查询所有的管理员用户
     * @param page
     * @param sno
     * @param roleName
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("user/{page}/{sno}/{roleName}/{startTime}/{endTime}")
    public PageInfo<RoleVo> findAdmin(@PathVariable("page")String page, @PathVariable("sno")String sno, @PathVariable("roleName") String roleName,
                                      @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime){
        System.out.println("传进来的数据：学号--" + sno + "角色--" + roleName + " 开始时间--" + startTime + " 结束时间--" + endTime);
        Timestamp sTime = null;
        Timestamp eTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("null".equals(sno)) {
            sno = null;
        }
        if ("null".equals(roleName)) {
            roleName = null;
        }
        try {
            if ("null".equals(startTime)) {
                sTime = null;
            } else {
                sTime = new Timestamp(sdf.parse(startTime).getTime());
            }
            if ("null".equals(endTime)) {
                eTime = null;
            } else {
                eTime = new Timestamp(sdf.parse(endTime).getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 分页，后端规定每页10条数据
        PageHelper.startPage(Integer.valueOf(page), 10);
        PageInfo<RoleVo> roleVos = new PageInfo<>(roleService.findAdmin(sno,roleName, sTime, eTime));
        System.out.println("页面信息是：" + roleVos);
        return roleVos;
    }

    /**
     * 新增管理员（角色分配）
     * @param userRole
     * @return
     */
    @PostMapping("addAdmin")
    public boolean add(@RequestBody UserRole userRole){
        return roleService.addAdmin(userRole);
    }

    /**
     * 查看用户是否存在
     * @param userRole
     * @return
     */
    @PostMapping("userNotExist")
    public boolean userNotExist(@RequestBody UserRole userRole){
        System.out.println("我要验证的用户是："+userRole.getUserSno());
        User user = userService.findBySno(userRole.getUserSno());
        if (user == null){
            return true;
        }
        return false;
    }

    /**
     * 查看角色是否在使用
     * @param userRole
     * @return
     */
    @PostMapping("roleIsExist")
    public boolean roleIsExist(@RequestBody UserRole userRole){
        boolean b = roleService.roleIsExist(userRole.getRoleId());
        if(b){
            return true;
        }
        return false;
    }

    /**
     * 删除管理员就是将管理员的角色改为普通同学
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    public boolean delete(@PathVariable Integer id){
        return roleService.deleteAdmin(id);
    }

    /**
     * 查询角色，分页，增强
     * @param page
     * @param roleName
     * @return
     */
    @GetMapping("findRole/{page}/{roleName}")
    public PageInfo<RoleDto> findRole(@PathVariable("page")String page, @PathVariable("roleName")String roleName){
        if ("null".equals(roleName)) {
            roleName = null;
        }
        // 分页，后端规定每页10条数据
        PageHelper.startPage(Integer.valueOf(page), 15);
        PageInfo<RoleDto> roleDto = new PageInfo<>(roleService.findRole(roleName));
        System.out.println("页面信息是：" + roleDto);

        return roleDto;
    }

    /**
     * 删除角色就是将角色的删除状态改为1
     * @param id
     * @return
     */
    @RequestMapping("deleteRole/{id}")
    @RequiresPermissions("/admin/all")
    public boolean deleteRole(@PathVariable("id")Integer id){
        Role role = roleService.findRoles(id);
        role.setDel(1);
        return roleService.update(role);
    }

    /**
     * 增加角色
     * @param roleDto
     * @return
     */
    @PostMapping("addRole")
    public boolean addRole(@RequestBody RoleDto roleDto){
        return roleService.addRole(roleDto);
    }

    /**
     * 角色是否存在
     * @param roleId
     * @param name
     * @return
     */
    @GetMapping("roleIsFind")
    public boolean roleIsFind(@RequestParam(value = "roleId",required = false) Integer roleId,@RequestParam(value = "name",required = false) String name){
        return roleService.roleIsFind(roleId,name);
    }

    /**
     * 根据角色id或name查询权限
     * @param roleId
     * @param roleName
     * @return
     */
    @GetMapping("findRightByRoleName/{roleId}/{roleName}")
    public List<Right> findRightByRoleName(@PathVariable("roleId") String roleId, @PathVariable("roleName") String roleName){
        if("null".equals(roleName)){
            roleName = null;
        }
        Integer rId = null;
        if(!"null".equals(roleId)){
            rId = Integer.valueOf(roleId);
        }
        return roleService.findRightByRoleName(rId,roleName);
    }

    @GetMapping("findRights1/{page}/{parentId}/{name}")
    public PageInfo<Right> findRights(@PathVariable("page")String page,@PathVariable("parentId")String parentId,@PathVariable("name")String name){
        Integer pId = null;
        if(!"null".equals(parentId)){
            pId = Integer.valueOf(parentId);
        }
        if("null".equals(name)){
            name = null;
        }
        PageHelper.startPage(Integer.valueOf(page),10);
        PageInfo<Right> info = new PageInfo<>(rightService.findAll(pId, name));
        return info;
    }

}
