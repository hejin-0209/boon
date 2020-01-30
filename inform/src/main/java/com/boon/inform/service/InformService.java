package com.boon.inform.service;

import com.boon.pojo.Inform;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的服务层
 */
public interface InformService {

    boolean addInform(Inform inform);

    Inform findById(Integer id);

    List<Inform> findAll();

    List<Inform> findBySno(String userSno);

    boolean update(Inform inform);

    boolean delete(Integer id);
}
