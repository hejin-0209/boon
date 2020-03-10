package com.boon.score.service.impl;

import com.boon.pojo.Course;
import com.boon.score.mapper.CourseMapper;
import com.boon.score.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的业务层实现类
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public boolean addCourse(Course course) {
        course.setDel(0);
        return courseMapper.addCourse(course);
    }

    @Override
    public List<Course> findCourse() {
        return courseMapper.findCourse();
    }

    @Override
    public Course findById(int id) {
        return courseMapper.findById(id);
    }

    @Override
    public boolean update(Course course) {
        return courseMapper.update(course);
    }

    @Override
    public boolean delete(int id) {
        Course course = courseMapper.findById(id);
        course.setDel(1);
        boolean b = courseMapper.update(course);
        return b;
    }

    @Override
    public Integer findCount() {
        return courseMapper.findCount();
    }

    @Override
    public boolean delBatch(int[] ids) {
        int i = 0;
        for (int id : ids) {
            Course course = courseMapper.findById(id);
            course.setDel(1);
            boolean b = courseMapper.update(course);
            if(b){
                i++;
            }
        }
        if(i == ids.length){
            return true;
        }
        return false;
    }
}
