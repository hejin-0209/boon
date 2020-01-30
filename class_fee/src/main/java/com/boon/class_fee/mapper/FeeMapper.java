package com.boon.class_fee.mapper;

import com.boon.pojo.ClassFee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的持久层
 */
@Mapper
public interface FeeMapper {

    boolean addFee(ClassFee fee);

    double findMoney();

    boolean updateFee(ClassFee fee);

    ClassFee findById(int id);

    List<ClassFee> findBySno(String sno);
}
