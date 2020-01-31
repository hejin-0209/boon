package com.boon.reward_and_punishment.mapper;

import com.boon.pojo.Capacity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  个人能力的持久层
 */
@Mapper
public interface CapacityMapper {

    boolean addCapacity(Capacity capacity);

    Capacity findBySno(String sno);

    Double convert(String sno);

    boolean update(Capacity capacity);

    List<Capacity> findAll();
}
