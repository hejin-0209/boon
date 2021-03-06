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

import java.util.ArrayList;
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
        ArrayList<String> list = new ArrayList<>();
        list.add("2016901127");
        list.add("2016901128");
        list.add("2016901130");
        list.add("2016901136");
        list.add("2016901141");
        list.add("2016901143");
        list.add("2016901148");
        list.add("2016901150");
        list.add("2016901134");

        Moral moral = new Moral();
        for (String s : list) {
            moral.setSno(s);
            boolean b = moralService.addMoral(moral);
        }
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
        List<Moral> morals = moralService.findMoral(null);
        for (Moral moral : morals) {
            System.out.println(moral);
        }
    }
}
