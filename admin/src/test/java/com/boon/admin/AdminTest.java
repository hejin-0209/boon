package com.boon.admin;

import com.boon.admin.service.ICapacityService;
import com.boon.admin.service.IUserService;
import com.boon.admin.utils.MD5Util;
import com.boon.pojo.Capacity;
import com.boon.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
//        d3422f0bc4e0ac64275469c02ade44c2
//        efb35e2e43d8f9806cb302403043534b
//        efb35e2e43d8f9806cb302403043534b\
    }

}
