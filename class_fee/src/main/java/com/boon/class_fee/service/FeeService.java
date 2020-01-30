package com.boon.class_fee.service;

import com.boon.pojo.ClassFee;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的服务层
 */
public interface FeeService {
    boolean addFee(ClassFee fee);

    double findMoney();

    boolean updateFee(ClassFee fee);

    ClassFee findById(int id);

    List<ClassFee> findBySno(String sno);
}
