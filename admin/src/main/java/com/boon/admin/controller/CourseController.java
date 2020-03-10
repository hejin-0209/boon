package com.boon.admin.controller;

import com.boon.admin.service.ICourseService;
import com.boon.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的控制层
 */
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    /* 课程的增加 */
    @PostMapping("addCourse")
    public boolean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    /* 查询所有的课程 */
    @GetMapping("findCourse")
    public List<Course> findCourse(){
        return courseService.findCourse();
    }

    /* 根据id查询 */
    @GetMapping("findById/{id}")
    public Course findById(@PathVariable int id){
        return courseService.findById(id);
    }

    /* 修改课程的信息 */
    @PostMapping("update")
    public boolean update(@RequestBody Course course){
        return courseService.update(course);
    }

    /* 删除一个课程 */
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable int id){
        return courseService.delete(id);
    }

    /* 获取课程的数量 */
    @GetMapping("findCount")
    public Integer findCount(){
        return courseService.findCount();
    }

    /* 批量删除课程 */
    @PostMapping("delBatch/{ids}")
    public boolean delBatch(@PathVariable(value = "ids") int[] ids){
        return courseService.delBatch(ids);
    }
}
