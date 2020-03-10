package com.boon.class_fee.service;

import com.boon.pojo.ClassFee;
import com.boon.pojo.Rewards;

import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的服务层
 */
public interface FeeService {
    boolean addFee(ClassFee fee);

    Double findMoney();

    boolean updateFee(ClassFee fee);

    ClassFee findById(int id);

    List<ClassFee> findBySno(String sno);

    List<ClassFee> findFee(String sno, Timestamp startTime, Timestamp endTime);
}
