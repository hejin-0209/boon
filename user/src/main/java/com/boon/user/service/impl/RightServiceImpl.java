package com.boon.user.service.impl;

import com.boon.pojo.Right;
import com.boon.user.mapper.RightMapper;
import com.boon.user.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Service
public class RightServiceImpl implements RightService {

    @Autowired
    private RightMapper rightMapper;

    @Override
    public List<Right> findAll(Integer parentId,String name) {
        return rightMapper.findAll(parentId,name);
    }

    @Override
    public List<Right> findRightByRoleId(Integer rId, Integer pId) {
        return rightMapper.findRightByRoleId(rId,pId);
    }
}
