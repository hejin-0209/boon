package com.boon.admin.service;

import com.boon.pojo.Inform;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IInformService {

    /**
     * 增加通知
     * @param inform
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/addInform")
    boolean addInform(@RequestBody Inform inform);

    /**
     * 通过id查询通知
     * @param id
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/findById/{id}")
    Inform findById(@PathVariable(value = "id") Integer id);

    /**
     * 查询所有的通知
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/findAll")
    List<Inform> findAll();

    /**
     * 通过管理员的学号来查询通知
     * @param userSno
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/findBySno/{sno}")
    List<Inform> findBySno(@PathVariable(value = "sno") String userSno);

    /**
     * 更新通知
     * @param inform
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/update")
    boolean update(@RequestBody Inform inform);

    /**
     * 删除通知
     * @param id
     * @return
     */
    @RequestMapping("boon/inform-proxy/inform/delete/{id}")
    boolean delete(@PathVariable(value = "id") Integer id);
}
