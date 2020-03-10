package com.boon.admin.service;

import com.boon.pojo.Inform;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "boon/inform-proxy/inform/addInform",method = RequestMethod.POST)
    boolean addInform(@RequestBody Inform inform);

    /**
     * 通过id查询通知
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/findById/{id}",method = RequestMethod.GET)
    Inform findById(@PathVariable(value = "id") Integer id);

    /**
     * 查询所有的通知
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/findAll/{page}/{sno}/{title}/{startTime}/{endTime}",method = RequestMethod.GET)
    PageInfo<Inform> findAll(@PathVariable(value = "page") String page, @PathVariable(value = "sno") String sno, @PathVariable(value = "title") String title,
                             @PathVariable(value = "startTime") String startTime, @PathVariable(value = "endTime") String endTime);

    /**
     * 通过管理员的学号来查询通知
     * @param userSno
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/findBySno/{sno}",method = RequestMethod.GET)
    List<Inform> findBySno(@PathVariable(value = "sno") String userSno);

    /**
     * 更新通知
     * @param inform
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/update",method = RequestMethod.POST)
    boolean update(@RequestBody Inform inform);

    /**
     * 删除通知
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/delete/{id}",method = RequestMethod.GET)
    boolean delete(@PathVariable(value = "id") Integer id);

    /**
     * 获取通知的数量
     * @return
     */
    @RequestMapping(value = "boon/inform-proxy/inform/findCount",method = RequestMethod.GET)
    Integer findCount();
}
