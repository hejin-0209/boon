package com.boon.class_fee.service.impl;

import com.boon.class_fee.mapper.FeeMapper;
import com.boon.class_fee.service.FeeService;
import com.boon.pojo.ClassFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的服务层实现类
 */
@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    private FeeMapper feeMapper;

    @Override
    public boolean addFee(ClassFee fee) {

        if(fee.getMoney()<fee.getExpend()){
            return false;
        }
        fee.setMoney(feeMapper.findMoney()+fee.getIncome()-fee.getExpend());
        return feeMapper.addFee(fee);
    }

    @Override
    public double findMoney() {
        return feeMapper.findMoney();
    }

    @Override
    public boolean updateFee(ClassFee fee) {
        return feeMapper.updateFee(fee);
    }

    @Override
    public ClassFee findById(int id) {
        return feeMapper.findById(id);
    }

    @Override
    public List<ClassFee> findBySno(String sno) {
        return feeMapper.findBySno(sno);
    }
}
