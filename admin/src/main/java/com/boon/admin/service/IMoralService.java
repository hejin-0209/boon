package com.boon.admin.service;

import com.boon.pojo.Moral;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("boon/reward-proxy/moral/addMoral")
    boolean addMoral(@RequestBody Moral moral);

    /**
     * 根据sno来查询思想品德
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/moral/findBySno/{sno}")
    Moral findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 将某个同学的思想品德的分查询出来，并折算好
     * @param sno
     * @return
     */
    @RequestMapping("boon/reward-proxy/moral/convert/{sno}")
    Double convert(@PathVariable(value = "sno") String sno);

    /**
     * 更新思想品德
     * @param moral
     * @return
     */
    @RequestMapping("boon/reward-proxy/moral/update")
    boolean update(@RequestBody Moral moral);

    /**
     * 查询所有的思想品德
     * @return
     */
    @RequestMapping("boon/reward-proxy/moral/findAll")
    List<Moral> findAll();

}
