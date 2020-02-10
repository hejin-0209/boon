package com.boon.admin;

import com.boon.admin.controller.CapacityController;
import com.boon.admin.service.ICapacityService;
import com.boon.pojo.Capacity;
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
    @Test
    public void test1(){
        Capacity capacity = new Capacity();
        capacity.setSno("2016901141");
        boolean b = capacityService.addCapacity(capacity);
        System.out.println(b);
    }

}
