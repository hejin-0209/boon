package com.boon.admin.service;

import com.boon.pojo.Health;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "boon/reward-proxy/health/addHealth",method = RequestMethod.POST)
    boolean addHealth(@RequestBody Health health);

    /**
     * 根据sno来查询卫生体育
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/health/findBySno/{sno}",method = RequestMethod.GET)
    Health findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 将某个同学的卫生体育的分查询出来，并折算好
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/health/convert/{sno}",method = RequestMethod.GET)
    Double convert(@PathVariable(value = "sno") String sno);

    /**
     * 更新卫生体育
     * @param health
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/health/update",method = RequestMethod.POST)
    boolean update(@RequestBody Health health);

    /**
     * 查询所有的卫生体育
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/health/findHealth/{sno}",method = RequestMethod.GET)
    List<Health> findHealth(@PathVariable(value = "sno") String sno);

    /**
     * 删除卫生体育
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/health/delete/{sno}",method = RequestMethod.DELETE)
    boolean delete(@PathVariable(value = "sno") String sno);
}
