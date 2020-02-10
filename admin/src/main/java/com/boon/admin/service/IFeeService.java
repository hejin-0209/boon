package com.boon.admin.service;

import com.boon.pojo.ClassFee;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IFeeService {

    /**
     * 增加班费的管理
     * @param fee
     * @return
     */
    @RequestMapping("boon/fee-proxy/fee/addFee")
    boolean addFee(@RequestBody ClassFee fee);

    /**
     * 查询班费还有多少
     * @return
     */
    @RequestMapping("boon/fee-proxy/fee/findMoney")
    double findMoney();

    /**
     * 班费管理的更新
     * @param fee
     * @return
     */
    @RequestMapping("boon/fee-proxy/fee/updateFee")
    boolean updateFee(@RequestBody ClassFee fee);

    /**
     * 根据id查询班费管理
     * @param id
     * @return
     */
    @RequestMapping("boon/fee-proxy/fee/findById/{id}")
    ClassFee findById(@PathVariable(value = "id") int id);

    /**
     * 根据学号来查询所管理的班费
     * @param sno
     * @return
     */
    @RequestMapping("boon/fee-proxy/fee/findBySno/{sno}")
    List<ClassFee> findBySno(@PathVariable(value = "sno") String sno);
}
