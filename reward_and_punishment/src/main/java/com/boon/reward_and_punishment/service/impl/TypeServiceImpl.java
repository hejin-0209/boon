package com.boon.reward_and_punishment.service.impl;

import com.boon.pojo.Type;
import com.boon.reward_and_punishment.mapper.TypeMapper;
import com.boon.reward_and_punishment.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  类型的服务层实现类
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public boolean addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Type findById(int id) {
        return typeMapper.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }

    @Override
    public List<Type> findParentId(Integer parentId) {
        return typeMapper.findParentId(parentId);
    }

    @Override
    public boolean update(Type type) {
        return typeMapper.update(type);
    }

    @Override
    public boolean delete(Integer id) {
        Type type = typeMapper.findById(id);
        type.setDel(1);
        return typeMapper.update(type);
    }

    @Override
    public boolean delBatch(int[] ids) {
        int i = 0;
        for (int id : ids) {
            Type type = typeMapper.findById(id);
            type.setDel(1);
            boolean b = typeMapper.update(type);
            if (b){
                i++;
            }
        }
        if(i == ids.length){
            return true;
        }
        return false;
    }
}
