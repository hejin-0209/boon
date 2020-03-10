package com.boon.reward_and_punishment.mapper;

import com.boon.pojo.Rewards;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的持久层
 */
@Mapper
public interface RewardMapper {


    boolean addReward(Rewards rewards);

    Rewards findFinalValue(@Param("sno") String sno , @Param("typeId") Integer typeId);

    List<Rewards> findBySno(String sno);

    List<Rewards> findByTypeId(Integer typeId);

    boolean update(Rewards rewards);

    Rewards findById(Integer id);

    List<Rewards> findRewards(@Param("name") String name, @Param("sno") String sno, @Param("typeId") Integer typeId, @Param("startTime") Timestamp startTime, @Param("endTime") Timestamp endTime);

}
