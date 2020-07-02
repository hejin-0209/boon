package com.boon.user;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import com.boon.pojo.User;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.RightDto;
import com.boon.pojo.vo.RoleDto;
import com.boon.pojo.vo.RoleVo;
import com.boon.user.controller.AdminController;
import com.boon.user.controller.UserController;
import com.boon.user.mapper.RoleMapper;
import com.boon.user.mapper.UserMapper;
import com.boon.user.service.RightService;
import com.boon.user.service.RoleService;
import com.boon.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdminController adminController;

    @Autowired
    private RightService rightService;

    @Test
    public void findAll() {
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findAll1() {
        List<User> users = userController.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /*增加用户*/
    @Test
    public void addUser() {
        User user = new User();
        user.setSno("2016901136");
        user.setName("张乘瑞");
        user.setPassword(user.getSno().substring(4));
        boolean b = userMapper.addUser(user);
        if (b) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    /*根据学号查询用户*/
    @Test
    public void findBySno() {
        String sno = "2016901147";
        User user = userMapper.findBySno(sno);
        if (user != null) {
            if (user.getState() != 1) {
                System.out.println("账号已禁用，请联系管理员");
            } else {
                System.out.println(user);
            }
        } else {
            System.out.println("该用户不存在！");
        }
    }

    /*删除用户*/
    @Test
    public void deleteBySno() {
        String sno = "2016901133";
        boolean b = userService.deleteBySno(sno);
        System.out.println(b);
    }

    /*更新用户数据*/
    @Test
    public void updateUser() {
        String sno = "2016901147";
        User user = userMapper.findBySno(sno);
        System.out.println(user);
        user.setPassword("123456");
        System.out.println(user);
        boolean b = userService.updateUser(user);
        System.out.println(b);
    }

    /*查询用户数量*/
    @Test
    public void findCount() {
        Integer count = userService.findCount();
        System.out.println(count);
    }

    /*给角色分配权限*/
    @Test
    public void AddRolrRight() {
        for (Integer roleId = 1; roleId <= 11; roleId++) {
            for (Integer RightId = 31; RightId <= 51; RightId++) {
                roleService.addRoleRight(roleId, RightId);
            }
        }
//        for (Integer rightId = 1; rightId <= 7 ; rightId ++){
//            roleService.addRoleRight(12,rightId);
//        }

    }

    /*获取用户的权限*/
    @Test
    public void findRight() {
        Set<String> rightByUserSno = userService.findRightByUserSno("admin");
        for (String right : rightByUserSno) {
            System.out.println("此用户拥有的权限是：" + right);
        }
    }

    /*获取管理员*/
    @Test
    public void FindAdmin() {
        List<RoleVo> roleVos = roleService.findAdmin("2016901147", null, null, null);
        for (RoleVo roleVo : roleVos) {
            System.out.println(roleVo.getId() + roleVo.getName() + roleVo.getDescription() + roleVo);
        }
    }

    /*查看用户是否存在*/
    @Test
    public void userNotExist() {
        UserRole userRole = new UserRole();
        userRole.setUserSno("2016901147");
        boolean b = adminController.userNotExist(userRole);
        System.out.println(b);
    }

    /*查询角色的权限*/
    @Test
    public void findRightByRoleName() {
        List<Right> rights = roleMapper.findRightByRoleName(null, null);
        for (Right right : rights) {
            System.out.println(right.getName());
        }

    }

    /*查询角色的加强类*/
    @Test
    public void roleDto() {
        List<RoleDto> roleDtos = roleService.findRole(null);
        for (RoleDto roleDto : roleDtos) {
            System.out.println(roleDto);
        }
    }

    /*测试集合*/
    @Test
    public void listTest() {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "你好1");
        list.add(1, "你好2");
        list.add(2, "你好3");
        list.add(3, "你好4");
        list.add(4, "你好5");
        list.add(5, "你好6");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /*获取所有的权限（分父类子类，且相对应）*/
    @Test
    public void parentChild() {
        List<Right> parents = rightService.findAll(1,null);
        List<RightDto> rightDtos = new ArrayList<>();
        int i = 0;
        for (Right parent : parents) {
            System.out.println("此时的父类是：" + parent);
            List<Right> childs = rightService.findAll(parent.getId(),null);
            RightDto rightDto = new RightDto();
            rightDto.setParent(parent);
            rightDto.setChilds(childs);
            rightDtos.add(i, rightDto);
            i++;
        }

        for (RightDto dto : rightDtos) {
            System.out.println(dto);
        }

    }

    @Test
    public void Test1() {
        boolean a = true;
        boolean b = false;

        if (a && b) {
            System.out.println("与的结果是：" + true);
        } else {
            System.out.println("与的结果是：" + false);
        }
        if (a || b) {
            System.out.println("或的结果是：" + true);
        }else{
            System.out.println("或的结果是："+ false);
        }
    }

    @Test
    public void roleIsFind() {
        Role role = roleMapper.roleIsFind(null, "超级管理员");
        if (role != null){
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }

    @Test
    public void findRightByRoleId(){
        List<Right> rightByRoleId = rightService.findRightByRoleId(2, 3);
        for (Right right : rightByRoleId) {
            System.out.println(right);
        }
    }

    @Test
    public void findRightByRoleIds(){



        List<RightDto> rights = adminController.findRights("2", "1");
        for (RightDto right : rights) {
            System.out.println(right);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("课程",1);
    }

    @Test
    public void test1(){

        int[] arr = new int[10];

        System.out.println("数组的第一项是："+arr[9]);

    }
}
