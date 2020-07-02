package com.boon.admin.service;

import com.boon.pojo.Course;
import com.boon.pojo.vo.FileDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的业务层
 */
@FeignClient(value = "boon-zuul")
public interface ICourseService {

    /**
     * 课程的增加
     * @param course
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/addCourse",method = RequestMethod.POST)
    boolean addCourse(@RequestBody Course course);

    /**
     * 查询所有的课程
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/findCourse",method = RequestMethod.GET)
    List<Course> findCourse();

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/findById/{id}" , method = RequestMethod.GET)
    Course findById(@PathVariable(value = "id") int id);

    /**
     * 修改课程的信息
     * @param course
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/update",method = RequestMethod.POST)
    boolean update(Course course);

    /**
     * 删除一个课程
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/delete/{id}",method = RequestMethod.DELETE)
    boolean delete(@PathVariable(value = "id") int id);

    /**
     * 获取课程的数量
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/findCount",method = RequestMethod.GET)
    Integer findCount();

    /**
     * 批量删除课程
     * @param ids
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/course/delBatch/{ids}",method = RequestMethod.POST)
    boolean delBatch(@PathVariable(value = "ids") int[] ids);

    @RequestMapping(value = "boon/score-proxy/course/bulkImport",method = RequestMethod.POST)
    boolean bulkImport(@PathVariable(value = "fileDto") FileDto fileDto);
}
