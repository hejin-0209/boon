package com.boon.admin.service;

import com.boon.pojo.Logs;

import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/12
 * version:      1.0
 * Description:  关于这个类的描述
 */
public interface LogService {

    void save(Logs logs);

    List<Logs> userLogs(String sno);

    List<Logs> findAll(String sno, String module, Timestamp sTime, Timestamp eTime);
}
