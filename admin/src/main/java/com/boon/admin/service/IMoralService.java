package com.boon.admin.service;

import com.boon.pojo.Moral;
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
 * Description:  思想品德的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IMoralService {

    /**
     * 新增思想品德
     * @param moral
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/addMoral",method = RequestMethod.POST)
    boolean addMoral(@RequestBody Moral moral);

    /**
     * 根据sno来查询思想品德
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/findBySno/{sno}",method = RequestMethod.GET)
    Moral findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 将某个同学的思想品德的分查询出来，并折算好
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/convert/{sno}",method = RequestMethod.GET)
    Double convert(@PathVariable(value = "sno") String sno);

    /**
     * 更新思想品德
     * @param moral
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/update",method = RequestMethod.POST)
    boolean update(@RequestBody Moral moral);

    /**
     * 查询所有的思想品德
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/findMoral/{sno}",method = RequestMethod.GET)
    List<Moral> findMoral(@PathVariable(value = "sno") String  sno);

    /**
     * 删除思想品德
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/moral/delete/{sno}",method = RequestMethod.DELETE)
    boolean delete(@PathVariable(value = "sno") String sno);
}
