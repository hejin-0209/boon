package com.boon.score.controller;

import com.boon.pojo.Course;
import com.boon.score.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
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
@Api(value = "课程的接口")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /* 课程的增加 */
    @PostMapping("addCourse")
    @ApiOperation(value = "添加一门课程" ,notes = "课程的信息请在后台管理中输入")
    public boolean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    /* 查询所有的课程 */
    @GetMapping("findCourse")
    @ApiOperation(value = "查询所有的课程")
    public List<Course> findCourse(){
        return courseService.findCourse();
    }

    /* 根据id查询 */
    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据id查询一门课程",notes = "课程的id由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "课程的id",
            required = true ,dataType = "int")
    public Course findById(@PathVariable int id){
        return courseService.findById(id);
    }

    /* 修改课程的信息 */
    @PostMapping("update")
    @ApiOperation(value = "修改课程的信息" , notes = "课程的信息再后台管理中修改，然后提交到后台")
    public boolean update(@RequestBody Course course){
        return courseService.update(course);
    }

    /* 删除一个课程 */
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除一门课程" , notes = "这里的删除不是真删，而是将课程的del字段的值改为1")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "课程的id",
            required = true ,dataType = "int")
    public boolean delete(@PathVariable int id){
        return courseService.delete(id);
    }

    /*查询课程的数量*/
    @GetMapping("findCount")
    @ApiOperation(value = "查询课程的数量",notes = "直接调用接口获取数据")
    public Integer findCount(){
        return courseService.findCount();
    }

    /* 批量删除课程 */
    @PostMapping("delBatch/{ids}")
    public boolean delBatch(@PathVariable(value = "ids") int[] ids){
        return courseService.delBatch(ids);
    }

}
