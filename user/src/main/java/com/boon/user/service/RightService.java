package com.boon.user.service;

import com.boon.pojo.Right;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
public interface RightService {
    List<Right> findAll(Integer parentId,String name);

    // 根据角色id和权限父类查询权限
    List<Right> findRightByRoleId(Integer rId, Integer pId);
}
