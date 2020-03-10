package com.boon.admin.service;

import com.boon.pojo.Rewards;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.PermitAll;
import java.sql.Timestamp;
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
    @RequestMapping(value = "boon/reward-proxy/reward/addReward",method = RequestMethod.POST)
    boolean addReward(@RequestBody Rewards rewards);

    /**
     * 查询某位同学的最后一次奖惩情况
     * @param sno
     * @param typeId
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/reward/findFinalValue/{sno}/{typeId}",method = RequestMethod.GET)
    Rewards findFinalValue(@PathVariable(value = "sno") String sno, @PathVariable(value = "typeId") Integer typeId);

    /**
     * 查询一位同学的奖惩情况
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/reward/findBySno/{sno}",method = RequestMethod.GET)
    List<Rewards> findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 查询某一类型的所有的奖惩情况
     * @param typeId
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/reward/findByTypeId/{typeId}",method = RequestMethod.GET)
    List<Rewards> findByTypeId(@PathVariable(value = "typeId") Integer typeId);

    /**
     * 更新奖惩情况
     * @param rewards
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/update/addReward",method = RequestMethod.POST)
    boolean update(@RequestBody Rewards rewards);

    /**
     * 根据id查找奖惩情况
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/reward/findById/{id}",method = RequestMethod.GET)
    Rewards findById(@PathVariable(value = "id") Integer id);

    /**
     * 查询所有的奖惩情况
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/reward/findRewards/{page}/{sno}/{typeId}/{startTime}/{endTime}",method = RequestMethod.GET)
    PageInfo<Rewards> findRewards(@PathVariable(value = "page")String page , @PathVariable(value = "sno") String sno , @PathVariable(value = "typeId") String typeId,
                                  @PathVariable(value = "startTime") String startTime , @PathVariable(value = "endTime") String endTime);

}
