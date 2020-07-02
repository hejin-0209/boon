package com.boon.user.mapper;

import com.boon.pojo.Right;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Mapper
public interface RightMapper {

    List<Right> findAll(@Param("parentId") Integer parentId,@Param("name") String name);

    Set<String> findRightByUserSno(String userSno);

    List<Right> findRightByRoleId(@Param("roleId") Integer roleId,@Param("parentId") Integer parentId);
}
