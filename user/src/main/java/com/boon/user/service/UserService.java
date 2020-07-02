package com.boon.user.service;

import com.boon.pojo.User;
import com.boon.user.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
public interface UserService {

    List<User> findAll();

    boolean addUser(User user);

    User findBySno(String sno);

    boolean updateUser(User user);

    boolean deleteBySno(String sno);

    Integer findCount();

    boolean changeState(String sno);

    boolean delBatch(String[] snos);

    JsonResult findUser(int page, int limit);

    List<User> findDelete();

    boolean changeDel(String sno);

    boolean restoreBatch(String[] snos);

    /***
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 获取用户权限
     *
     * @param userSno userSno
     * @return 用户权限
     */
    Set<String> findRightByUserSno(String userSno);


    Integer findAdminCount();

    boolean uploadPhoto(User user);
}
