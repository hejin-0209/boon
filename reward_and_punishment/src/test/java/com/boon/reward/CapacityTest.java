package com.boon.reward;

import com.boon.pojo.Capacity;
import com.boon.reward_and_punishment.RewardApplication;
import com.boon.reward_and_punishment.mapper.CapacityMapper;
import com.boon.reward_and_punishment.service.CapacityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RewardApplication.class)
public class CapacityTest {

    @Autowired
    private CapacityService capacityService;

    @Autowired
    private CapacityMapper capacityMapper;

    @Test
    public void addCapacity(){
        Capacity capacity = new Capacity();
        capacity.setSno("2016901138");
        boolean b = capacityService.addCapacity(capacity);
        System.out.println(b);
    }

    @Test
    public void findBySno(){
        Capacity capacity = capacityService.findBySno("2016901147");
        System.out.println(capacity);
    }

    @Test
    public void convert(){
        Double convert = capacityService.convert("2016901147");
        System.out.println(convert);
    }

    @Test
    public void update(){
        Capacity capacity = capacityService.findBySno("2016901147");
        System.out.println(capacity);
        capacity.setProportion(0.3);
        System.out.println(capacity);
        boolean b = capacityService.update(capacity);
        System.out.println(b);
    }

    @Test
    public void findAll(){
        List<Capacity> capacitys = capacityService.findCapacity(null);
        for (Capacity capacity : capacitys) {
            System.out.println(capacity);
        }
    }
}
