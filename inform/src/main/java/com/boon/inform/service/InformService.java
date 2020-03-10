package com.boon.inform.service;

import com.boon.pojo.Inform;

import java.sql.Timestamp;
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

    List<Inform> findAll(String sno, String title, Timestamp sTime,Timestamp eTime);

    List<Inform> findBySno(String userSno);

    boolean update(Inform inform);

    boolean delete(Integer id);

    Integer findCount();

}
