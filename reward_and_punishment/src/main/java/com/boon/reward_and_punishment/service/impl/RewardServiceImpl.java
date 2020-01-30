package com.boon.reward_and_punishment.service.impl;

import com.boon.pojo.Rewards;
import com.boon.reward_and_punishment.mapper.RewardMapper;
import com.boon.reward_and_punishment.service.RewardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的服务层的实现类
 */
@Service
public class RewardServiceImpl implements RewardService {

    @Autowired
    private RewardMapper rewardMapper;

    @Override
    public boolean addReward(Rewards rewards) {
        // 初始值等于该同学最后一次的奖惩的最终值，如果是第一次新增奖惩，则为0
        Integer finalValue = rewardMapper.findFinalValue(rewards.getSno(), rewards.getTypeId()).getFinalValue();
        if(finalValue == null){
            rewards.setInitialValue(0);
        }else{
            rewards.setInitialValue(finalValue);
        }
        //设置奖惩的值
        if(rewards.getReward() != null){
            rewards.setPunish(0);
        }else {
            rewards.setReward(0);
        }
        // 最终值等于初始值加上奖赏减去处罚
        rewards.setFinalValue(rewards.getInitialValue()+rewards.getReward()-rewards.getPunish());
        return rewardMapper.addReward(rewards);
    }

    @Override
    public Rewards findFinalValue(@Param("sno") String sno , @Param("typeId") Integer typeId) {
        return rewardMapper.findFinalValue(sno,typeId);
    }

    @Override
    public List<Rewards> findBySno(String sno) {
        return rewardMapper.findBySno(sno);
    }

    @Override
    public List<Rewards> findByTypeId(Integer typeId) {
        return rewardMapper.findByTypeId(typeId);
    }

    @Override
    public boolean update(Rewards rewards) {
        return rewardMapper.update(rewards);
    }

    @Override
    public Rewards findById(Integer id) {
        return rewardMapper.findById(id);
    }

    @Override
    public List<Rewards> findAll() {
        return rewardMapper.findAll ();
    }
}
