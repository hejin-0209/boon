package com.boon.admin;

import com.boon.admin.common.dto.LogMapper;
import com.boon.admin.common.vo.Result;
import com.boon.admin.controller.ScoreController;
import com.boon.admin.service.IAdminService;
import com.boon.admin.service.ICapacityService;
import com.boon.admin.service.IUserService;
import com.boon.admin.service.LogService;
import com.boon.admin.utils.MD5Util;
import com.boon.pojo.Capacity;
import com.boon.pojo.Comprehensive;
import com.boon.pojo.Logs;
import com.boon.pojo.UserRole;
import com.boon.pojo.vo.JsonResult;
import com.boon.pojo.vo.RoleVo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/31
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class AdminTest {

    @Autowired
    private ICapacityService capacityService;

    @Autowired
    private IUserService userService;

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private LogService logService;

    @Autowired
    private IAdminService adminService;

    @Autowired
    private ScoreController scoreController;

    @Test
    public void test1(){
        Capacity capacity = new Capacity();
        capacity.setSno("2016901141");
        boolean b = capacityService.addCapacity(capacity);
        System.out.println(b);
    }

    @Test
    public void test2(){
        String encrypt = MD5Util.encrypt("901147");
        System.out.println(encrypt);
    }

    @Test
    public void test3(){
//        User user = new User();
//        user.setSno("2016901147");
//        user.setName("何劲");
        String encoder = MD5Util.passwordEncoder("901141", "张海龙salt");
        System.out.println(encoder);
        //de61431d9dd22127ce8dcb1ad0f3d5a2
        //de61431d9dd22127ce8dcb1ad0f3d5a2
    }

    /*获取本机ip*/
    @Test
    public void test4(){
        InetAddress ia = null;

        try {
            ia = ia.getLocalHost();

            String hostIp = ia.getHostAddress();
            System.out.println(hostIp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /*获取全部日志*/
    @Test
    public void Test5(){
        List<Logs> logs = logMapper.findAll(null, null, null, null, null);
        for (Logs log : logs) {
            System.out.println(log);
        }
        System.out.println(logs.size());
    }

    /*判断是否为中文*/
    public static boolean isChinese(String input){
        return input.matches("^[\u4e00-\u9fa5]+$");
    }

    @Test
    public void Test6(){
        System.out.println(isChinese("成绩管理员"));
    }

    /*查询用户是否存在*/
    @Test
    public void userNotExist(){
        UserRole userRole = new UserRole();
        userRole.setUserSno("2016901150");
        boolean b = adminService.userNotExist(userRole);
        System.out.println(b);
    }

    @Test
    public void FindAdmin(){
        PageInfo<RoleVo> admin = adminService.findAdmin("1", null, null, null, null);
        System.out.println(admin);
    }

    @Test
    public void comprehensives(){
        Result comprehensives = scoreController.comprehensives(1,10);
        PageInfo<Comprehensive> info =(PageInfo<Comprehensive>) comprehensives.getData();
        List<Comprehensive> list = info.getList();
        System.out.println("before sort:");
        for (Comprehensive comprehensive : list) {
            System.out.println("sno:"+comprehensive.getSno()+"total:"+comprehensive.getComprehensiveTotal());
        }
    }

    @Test
    public void test5(){
        int i = (int) 1.5;
        System.out.println(i);

    }

}
