package com.boon.reward_and_punishment.service;

import com.boon.pojo.Rewards;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的服务层
 */
public interface RewardService {

    boolean addReward(Rewards rewards);

    Rewards findFinalValue(@Param("sno") String sno , @Param("typeId") Integer typeId);

    List<Rewards> findBySno(String sno);

    List<Rewards> findByTypeId(Integer typeId);

    boolean update(Rewards rewards);

    Rewards findById(Integer id);

    List<Rewards> findAll();

}
