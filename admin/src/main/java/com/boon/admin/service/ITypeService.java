package com.boon.admin.service;

import com.boon.pojo.Type;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  类型的服务层
 */
@FeignClient(value = "boon-zuul")
public interface ITypeService {

    /**
     * 新增类型
     * @param type
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/addType",method = RequestMethod.POST)
    boolean addType(@RequestBody Type type);

    /**
     * 根据id查询类型
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/findById/{id}",method = RequestMethod.GET)
    Type findById(@PathVariable(value = "id") int id);

    /**
     * 查询所有的类型
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/findAll",method = RequestMethod.GET)
    List<Type> findAll();

    /**
     * 根据父类id查询类型
     * @param parentId
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/findParentId/{parentId}",method = RequestMethod.GET)
    List<Type> findParentId(@PathVariable(value = "parentId") Integer parentId);

    /**
     * 更新类型的信息
     * @param type
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/update",method = RequestMethod.POST)
    boolean update(@RequestBody Type type);

    /**
     * 删除类型
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/delete/{id}",method = RequestMethod.DELETE)
    boolean delete(@PathVariable(value = "id") Integer id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "boon/reward-proxy/type/delBatch/{ids}",method = RequestMethod.DELETE)
    boolean delBatch(@PathVariable(value = "ids") int[] ids);
}
