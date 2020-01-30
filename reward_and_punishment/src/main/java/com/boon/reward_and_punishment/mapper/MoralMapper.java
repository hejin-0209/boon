package com.boon.reward_and_punishment.mapper;

import com.boon.pojo.Moral;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  思想品德的持久层
 */
@Mapper
public interface MoralMapper {
    boolean addMoral(Moral moral);

    Moral findBySno(String sno);

    Double convert(String sno);

    boolean update(Moral moral);

    List<Moral> findAll();

}
