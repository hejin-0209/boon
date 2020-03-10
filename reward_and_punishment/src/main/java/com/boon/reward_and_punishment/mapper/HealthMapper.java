package com.boon.reward_and_punishment.mapper;

import com.boon.pojo.Health;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的持久层
 */
@Mapper
public interface HealthMapper {

    boolean addHealth(Health health);

    Health findBySno(String sno);

    Double convert(String sno);

    boolean update(Health health);

    List<Health> findHealth(String sno);
}
