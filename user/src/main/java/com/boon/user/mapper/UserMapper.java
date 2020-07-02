package com.boon.user.mapper;

import com.boon.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Mapper
public interface UserMapper {

    List<User> findAll();

    boolean addUser(User user);

    User findBySno(String sno);

    boolean updateUser(User user);

    Integer findCount();

    List<User> findDelete();

    Integer findAdminCount();

}
