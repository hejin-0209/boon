package com.boon.reward_and_punishment.mapper;

import com.boon.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  类型的持久层
 */
@Mapper
public interface TypeMapper {


    boolean addType(Type type);

    Type findById(int id);

    List<Type> findAll();

    List<Type> findParentId(Integer parentId);

    boolean update(Type type);

}
