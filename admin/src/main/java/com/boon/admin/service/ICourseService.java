package com.boon.admin.service;

import com.boon.pojo.Course;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("boon/score-proxy/course/addCourse")
    boolean addCourse(@RequestBody Course course);

    /**
     * 查询所有的课程
     * @return
     */
    @RequestMapping("boon/score-proxy/course/findCourse")
    List<Course> findCourse();

    /**
     * 根据id查询课程
     * @param id
     * @return
     */
    @RequestMapping("boon/score-proxy/course/findById/{id}")
    Course findById(@PathVariable(value = "id") int id);

    /**
     * 修改课程的信息
     * @param course
     * @return
     */
    @RequestMapping("boon/score-proxy/course/update")
    boolean update(Course course);

    /**
     * 删除一个课程
     * @param id
     * @return
     */
    @RequestMapping("boon/score-proxy/course/delete/{id}")
    boolean delete(@PathVariable(value = "id") int id);
}
