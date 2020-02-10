package com.boon.admin.service;

import com.boon.pojo.Capacity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/30
 * version:      1.0
 * Description:  个人能力的服务层
 */
@FeignClient(value = "boon-zuul")
public interface ICapacityService {

    /**
     * 添加个人能力
     * @param capacity
     * @return
     */
    @RequestMapping("boon/reward-proxy/capacity/addCapacity")
    boolean addCapacity(@RequestBody Capacity capacity);

    /**
     *根据sno来查询个人能力
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/capacity/findBySno/{sno}")
    Capacity findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 将某个同学的个人能力的分查询出来，并折算好
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/capacity/convert/{sno}")
    Double convert(@PathVariable(value = "sno") String sno);

    /**
     * 更新个人能力
     * @param capacity
     * @return
     */
    @RequestMapping("boon/reward-proxy/capacity/update")
    boolean update(@RequestBody Capacity capacity);

    /**
     * 查询所有的个人能力
     * @return
     */
    @RequestMapping("boon/reward-proxy/capacity/findAll")
    List<Capacity> findAll();
}
