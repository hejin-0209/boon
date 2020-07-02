package com.boon.admin.service;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RightDto;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * author:       HeJin
 * Date:         2020/3/16
 * version:      1.0
 * Description:  关于这个类的描述
 */
@FeignClient(value = "boon-zuul")
public interface IAdminService {

    /**
     * 查询所有的管理员用户
     * @param page
     * @param sno
     * @param roleName
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/user/{page}/{sno}/{roleName}/{startTime}/{endTime}",method = RequestMethod.GET)
    PageInfo<RoleVo> findAdmin(@PathVariable("page")String page, @PathVariable("sno")String sno, @PathVariable("roleName") String roleName,
                               @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime);

    /**
     * 新增管理员（角色分配）
     * @param userRole
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/addAdmin",method = RequestMethod.POST)
    boolean add(@RequestBody UserRole userRole);

    /**
     * 查看用户是否存在
     * @param userRole
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/userNotExist",method = RequestMethod.POST)
    boolean userNotExist(@RequestBody UserRole userRole);

    /**
     * 查看角色是否在使用
     * @param userRole
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/roleIsExist",method = RequestMethod.POST)
    boolean roleIsExist(@RequestBody UserRole userRole);

    /**
     * 查询所有的角色
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/findRole",method = RequestMethod.GET)
    List<Role> findRole();

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/delete/{id}",method = RequestMethod.GET)
    boolean delete(@PathVariable("id") Integer id);

    /**
     * 查询所有的角色
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/findRole/{page}/{roleName}",method = RequestMethod.GET)
    PageInfo<RoleDto> findRole(@PathVariable("page")String page, @PathVariable("roleName")String roleName);

    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/deleteRole/{id}",method = RequestMethod.GET)
    boolean deleteRole(@PathVariable("id") Integer id);

    /**
     * 根据父类id查询权限
     * @param page
     * @param parentId
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/findRight/{page}/{parentId}",method = RequestMethod.GET)
    PageInfo<RightDto> findRight(@PathVariable("page")String page, @PathVariable("parentId") String parentId);

    /**
     * 添加角色
     * @param roleDto
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/addRole",method = RequestMethod.POST)
    boolean addRole(@RequestBody RoleDto roleDto);

    /**
     * 查看角色是否存在
     * @param roleId
     * @param name
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/roleIsFind",method = RequestMethod.GET)
    boolean roleIsFind(@RequestParam(value = "roleId",required = false) Integer roleId,@RequestParam(value = "name",required = false) String name);

    /**
     * 根据角色id或name查询权限
     * @param roleId
     * @param roleName
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/findRightByRoleName/{roleId}/{roleName}",method = RequestMethod.GET)
    List<Right> findRightByRoleName(@PathVariable("roleId") String roleId, @PathVariable("roleName") String roleName);

    /**
     * 根据父类id和角色查询权限
     * @param roleId
     * @param parentId
     * @return
     */
    @RequestMapping(value = "boon/user-proxy/admin/findRights/{roleId}/{parentId}",method = RequestMethod.GET)
    List<RightDto> findRights(@PathVariable("roleId")String roleId, @PathVariable("parentId") String parentId);

    @RequestMapping(value = "boon/user-proxy/admin/findRights1/{page}/{parentId}/{name}",method = RequestMethod.GET)
    PageInfo<Right> findRights(@PathVariable("page")String page,@PathVariable("parentId")String parentId,@PathVariable("name")String name);
}
