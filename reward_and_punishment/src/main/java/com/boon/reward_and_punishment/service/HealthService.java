package com.boon.reward_and_punishment.service;

import com.boon.pojo.Health;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的服务层
 */
public interface HealthService {

    boolean addHealth(Health health);

    Health findBySno(String sno);

    Double convert(String sno);

    boolean update(Health health);

    List<Health> findHealth(String sno);

    boolean delete(String sno);
}
