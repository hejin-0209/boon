package com.boon.reward;

import com.boon.pojo.Rewards;
import com.boon.reward_and_punishment.RewardApplication;
import com.boon.reward_and_punishment.mapper.RewardMapper;
import com.boon.reward_and_punishment.service.RewardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RewardApplication.class)
public class RewardTest {

    @Autowired
    private RewardService rewardService;

    @Autowired
    private RewardMapper rewardMapper;

    @Test
    public void findFinalValue(){
        Rewards finalValue = rewardService.findFinalValue("2016901147",2);
        System.out.println(finalValue);
    }

    @Test
    public void addReward(){
        Rewards rewards = new Rewards();
        rewards.setSno("2016901138");
        rewards.setTypeId(1);
        rewards.setReward(2);
        rewards.setDescription("奖状一张");
        boolean b = rewardService.addReward(rewards);
        System.out.println(b);
    }

    @Test
    public void findBySno(){
        List<Rewards> bySno = rewardService.findBySno("2016901147");
        for (Rewards rewards : bySno) {
            System.out.println(rewards);
        }
    }

    @Test
    public void findByTypeId(){
        List<Rewards> rewards = rewardService.findByTypeId(1);
        for (Rewards reward : rewards) {
            System.out.println(reward);
        }
    }

    @Test
    public void update(){
        Rewards rewards = rewardService.findById(6);
        System.out.println(rewards);
        rewards.setDescription("荣誉证书一本");
        boolean update = rewardService.update(rewards);
        System.out.println(update);
    }

    @Test
    public void findAll(){
        List<Rewards> rewards = rewardService.findAll();
        for (Rewards reward : rewards) {
            System.out.println(reward);
        }
    }
}
