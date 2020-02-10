package com.boon.admin.service;

import com.boon.pojo.Rewards;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  奖惩的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IRewardService {

    /**
     * 新增一个奖惩
     * @param rewards
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/addReward")
    boolean addReward(@RequestBody Rewards rewards);

    /**
     * 查询某位同学的最后一次奖惩情况
     * @param sno
     * @param typeId
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/findFinalValue/{sno}/{typeId}")
    Rewards findFinalValue(@PathVariable(value = "sno") String sno, @PathVariable(value = "typeId") Integer typeId);

    /**
     * 查询一位同学的奖惩情况
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/findBySno/{sno}")
    List<Rewards> findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 查询某一类型的所有的奖惩情况
     * @param typeId
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/findByTypeId/{typeId}")
    List<Rewards> findByTypeId(@PathVariable(value = "typeId") Integer typeId);

    /**
     * 更新奖惩情况
     * @param rewards
     * @return
     */
    @RequestMapping("boon/reward-proxy/update/addReward")
    boolean update(@RequestBody Rewards rewards);

    /**
     * 根据id查找奖惩情况
     * @param id
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/findById/{id}")
    Rewards findById(@PathVariable(value = "id") Integer id);

    /**
     * 查询所有的奖惩情况
     * @return
     */
    @RequestMapping("boon/reward-proxy/reward/findAll")
    List<Rewards> findAll();

}
