package com.boon.reward_and_punishment.service.impl;

import com.boon.pojo.Health;
import com.boon.reward_and_punishment.mapper.HealthMapper;
import com.boon.reward_and_punishment.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的服务层实现类
 */
@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthMapper healthMapper;


    @Override
    public boolean addHealth(Health health) {
        if(health != null){
            // 当health不为空，这些值为空的时候，为其设置一个默认值，一般为15
            if (health.getPhysique() == null){
                health.setPhysique(15);
            }
            if(health.getHygiene() == null){
                health.setHygiene(15);
            }
            if(health.getExercise() == null){
                health.setExercise(15);
            }
            if(health.getLabour() == null){
                health.setLabour(15);
            }
        }
        // 奖惩中的学号必须和卫生体育中的学号一样
        health.setRewardsSno(health.getSno());
        // 卫生体育在综测中的占比是10%，用0.1表示
        health.setProportion(0.1);
        return healthMapper.addHealth(health);
    }

    @Override
    public Health findBySno(String sno) {
        return healthMapper.findBySno(sno);
    }

    @Override
    public Double convert(String sno) {
        return healthMapper.convert(sno);
    }

    @Override
    public boolean update(Health health) {
        return healthMapper.update(health);
    }

    @Override
    public List<Health> findAll() {
        return healthMapper.findAll();
    }
}
