package com.boon.reward_and_punishment.service.impl;

import com.boon.pojo.Moral;
import com.boon.reward_and_punishment.mapper.MoralMapper;
import com.boon.reward_and_punishment.service.MoralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  思想品德的服务层的实现类
 */
@Service
public class MoralServiceImpl implements MoralService {

    @Autowired
    private MoralMapper moralMapper;

    @Override
    public boolean addMoral(Moral moral) {
        if(moral != null){
            // 当moral不为空，这些值为空的时候，为其设置一个默认值，一般为15
            if (moral.getPolitics() == null){
                moral.setPolitics(15);
            }
            if(moral.getLearn() == null){
                moral.setLearn(15);
            }
            if(moral.getCulture() == null){
                moral.setCulture(15);
            }
            if(moral.getDiscipline() == null){
                moral.setDiscipline(15);
            }
        }
        // 奖惩中的学号必须和思想品德中的学号一样
        moral.setRewardsSno(moral.getSno());
        // 思想品德在综测中的占比是20%，用0.2表示
        moral.setProportion(0.2);
        return moralMapper.addMoral(moral);
    }

    @Override
    public Moral findBySno(String sno) {
        return moralMapper.findBySno(sno);
    }

    @Override
    public Double convert(String sno) {
        return moralMapper.convert(sno);
    }

    @Override
    public boolean update(Moral moral) {
        return moralMapper.update(moral);
    }

    @Override
    public List<Moral> findAll() {
        return moralMapper.findAll();
    }
}
