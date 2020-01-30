package com.boon.reward_and_punishment.service;

import com.boon.pojo.Type;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  类型的服务层
 */
public interface TypeService {

    boolean addType(Type type);

    Type findById(int id);

    List<Type> findAll();

    List<Type> findParentId(Integer parentId);

    boolean update(Type type);

    boolean delete(Integer id);
}
