package com.boon.reward;

import com.boon.pojo.Health;
import com.boon.reward_and_punishment.RewardApplication;
import com.boon.reward_and_punishment.mapper.HealthMapper;
import com.boon.reward_and_punishment.service.HealthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RewardApplication.class)
public class HealthTest {

    @Autowired
    private HealthService healthService;

    @Autowired
    private HealthMapper healthMapper;

    @Test
    public void addHealth(){
        Health health = new Health();
        health.setSno("2016901138");
        boolean b = healthService.addHealth(health);
        System.out.println(b);
    }

    @Test
    public void findBySno(){
        Health health = healthService.findBySno("2016901147");
        System.out.println(health);
    }

    @Test
    public void convert(){
        Double convert = healthService.convert("2016901138");
        System.out.println(convert);
    }

    @Test
    public void update(){
        Health health = healthService.findBySno("2016901147");
        System.out.println(health);
        health.setProportion(0.3);
        System.out.println(health);
        boolean b = healthService.update(health);
        System.out.println(b);
    }

    @Test
    public void findAll(){
        List<Health> healths = healthService.findAll();
        for (Health health : healths) {
            System.out.println(health);
        }
    }
}
