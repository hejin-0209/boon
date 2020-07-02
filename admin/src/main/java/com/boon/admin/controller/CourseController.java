package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.ICourseService;
import com.boon.pojo.Course;
import com.boon.pojo.vo.FileDto;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @LogAnnotation
    @ApiOperation("课程的新增")
    @PostMapping("addCourse")
    @RequiresPermissions("/course/addCourse")
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
    @LogAnnotation
    @ApiOperation("课程的修改")
    @PostMapping("update")
    @RequiresPermissions("/course/update")
    public boolean update(@RequestBody Course course){
        return courseService.update(course);
    }

    /* 删除一个课程 */
    @LogAnnotation
    @ApiOperation("删除课程")
    @DeleteMapping("delete/{id}")
    @RequiresPermissions("/course/delete")
    public boolean delete(@PathVariable int id){
        return courseService.delete(id);
    }

    /* 获取课程的数量 */
    @GetMapping("findCount")
    public Integer findCount(){
        return courseService.findCount();
    }

    /* 批量删除课程 */
    @LogAnnotation
    @ApiOperation("批量删除课程")
    @PostMapping("delBatch/{ids}")
    @RequiresPermissions("/course/delBatch")
    public boolean delBatch(@PathVariable(value = "ids") int[] ids){
        return courseService.delBatch(ids);
    }

    /*课程的新增*/
    @PostMapping("bulkImport")
    @RequiresPermissions("/course/addCourse")
    @LogAnnotation
    @ApiOperation("课程的新增")
    public boolean bulkImport(MultipartFile file) throws Exception{

        FileDto fileDto = new FileDto();
        fileDto.setInputStream(file.getInputStream());
        return courseService.bulkImport(fileDto);
    }
}
