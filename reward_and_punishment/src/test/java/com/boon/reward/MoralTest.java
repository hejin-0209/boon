package com.boon.reward;

import com.boon.pojo.Moral;
import com.boon.reward_and_punishment.RewardApplication;
import com.boon.reward_and_punishment.mapper.MoralMapper;
import com.boon.reward_and_punishment.service.MoralService;
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
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RewardApplication.class)
public class MoralTest {

    @Autowired
    private MoralService moralService;

    @Autowired
    private MoralMapper moralMapper;

    @Test
    public void addMoral(){
        Moral moral = new Moral();
        moral.setSno("2016901147");
        boolean b = moralService.addMoral(moral);
        System.out.println(b);
    }

    @Test
    public void findBySno(){
        Moral moral = moralService.findBySno("2016901147");
        System.out.println(moral);
    }

    @Test
    public void convert(){
        Double convert = moralService.convert("2016901138");
        System.out.println(convert);
    }

    @Test
    public void update(){
        Moral moral = moralService.findBySno("2016901147");
        System.out.println(moral);
        moral.setProportion(0.3);
        System.out.println(moral);
        boolean b = moralService.update(moral);
        System.out.println(b);
    }

    @Test
    public void findAll(){
        List<Moral> morals = moralService.findAll();
        for (Moral moral : morals) {
            System.out.println(moral);
        }
    }
}
