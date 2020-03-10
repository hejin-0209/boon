package com.boon.reward_and_punishment.service;

import com.boon.pojo.Moral;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  思想品德的服务层
 */
public interface MoralService {

    boolean addMoral(Moral moral);

    Moral findBySno(String sno);

    Double convert(String sno);

    boolean update(Moral moral);

    List<Moral> findMoral(String sno);

    boolean delete(String sno);
}
