package com.boon.reward_and_punishment.service;

import com.boon.pojo.Capacity;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  个人能力的服务层
 */
public interface CapacityService {

    boolean addCapacity(Capacity capacity);

    Capacity findBySno(String sno);

    Double convert(String sno);

    boolean update(Capacity capacity);

    List<Capacity> findAll();
}
