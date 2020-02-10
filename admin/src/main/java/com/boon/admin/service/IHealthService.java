package com.boon.admin.service;

import com.boon.pojo.Health;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/29
 * version:      1.0
 * Description:  卫生体育的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IHealthService {

    /**
     * 新增卫生体育
     * @param health
     * @return
     */
    @RequestMapping("boon/reward-proxy/health/addHealth")
    boolean addHealth(@RequestBody Health health);

    /**
     * 根据sno来查询卫生体育
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/health/findBySno/{sno}")
    Health findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 将某个同学的卫生体育的分查询出来，并折算好
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/health/convert/{sno}")
    Double convert(@PathVariable(value = "sno") String sno);

    /**
     * 更新卫生体育
     * @param health
     * @return
     */
    @RequestMapping("boon/reward-proxy/health/update")
    boolean update(@RequestBody Health health);

    /**
     * 查询所有的卫生体育
     * @return
     */
    @RequestMapping("boon/reward-proxy/health/findAll")
    List<Health> findAll();
}
