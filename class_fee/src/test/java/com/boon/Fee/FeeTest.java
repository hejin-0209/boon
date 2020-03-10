package com.boon.Fee;

import com.boon.class_fee.ClassFeeApplication;
import com.boon.class_fee.mapper.FeeMapper;
import com.boon.class_fee.service.FeeService;
import com.boon.pojo.ClassFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClassFeeApplication.class)
public class FeeTest {

    @Autowired
    private FeeMapper feeMapper;

    @Autowired
    private FeeService feeService;

    @Test
    public void addFee(){
        ClassFee fee = new ClassFee();
        fee.setIncome(2500);
        fee.setUserSno("2016901147");
        fee.setOperationTime(new Timestamp(new Date().getTime()));
        fee.setDescription("每人交了50的班费");
        boolean b = feeService.addFee(fee);
        System.out.println(b);
    }

    @Test
    public void findMoney(){
        Double money = feeService.findMoney();
        System.out.println(money);
    }

    @Test
    public void test(){
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(date);
//        long time = date.getTime();
//        System.out.println(time);
//        System.out.println(date);
//        System.out.println(format);
        System.out.println(new Timestamp(new Date().getTime()));
    }

    @Test
    public void updateFee(){
        ClassFee fee = feeService.findById(1);
        System.out.println(fee);
        fee.setOperationTime(new Timestamp(new Date().getTime()));
        System.out.println(fee);
        boolean b = feeService.updateFee(fee);
        System.out.println(b);
    }

    @Test
    public void findBySno(){
        List<ClassFee> fees = feeService.findBySno("2016901138");
        for (ClassFee fee : fees) {
            System.out.println(fee);
        }
    }
}