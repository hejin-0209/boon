package com.boon.reward_and_punishment.service.impl;

import com.boon.pojo.Capacity;
import com.boon.reward_and_punishment.mapper.CapacityMapper;
import com.boon.reward_and_punishment.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  个人能力的服务层实现类
 */
@Service
public class CapacityServiceImpl implements CapacityService {

    @Autowired
    private CapacityMapper capacityMapper;

    @Override
    public boolean addCapacity(Capacity capacity) {
        if(capacity != null){
            // 当Capacity不为空，个人能力的基础值是60
            if (capacity.getBasic() == null || capacity.getBasic() == 0){
                capacity.setBasic(60);
            }
        }
        // 奖惩中的学号必须和个人能力中的学号一样
        capacity.setRewardsSno(capacity.getSno());
        // 个人能力在综测中的占比是10%，用0.1表示
        capacity.setProportion(0.1);
        return capacityMapper.addCapacity(capacity);
    }

    @Override
    public Capacity findBySno(String sno) {
        return capacityMapper.findBySno(sno);
    }

    @Override
    public Double convert(String sno) {
        return capacityMapper.convert(sno);
    }

    @Override
    public boolean update(Capacity capacity) {
        return capacityMapper.update(capacity);
    }

    @Override
    public List<Capacity> findCapacity(String sno) {
        return capacityMapper.findCapacity(sno);
    }

    @Override
    public boolean delete(String sno) {
        Capacity capacity = capacityMapper.findBySno(sno);
        capacity.setDel(1);

        return capacityMapper.update(capacity);
    }

}
