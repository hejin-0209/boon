package com.boon.score.service;

import com.boon.pojo.Course;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的业务层
 */
public interface CourseService {

    boolean addCourse(Course course);

    List<Course> findCourse();

    Course findById(int id);

    boolean update(Course course);

    boolean delete(int id);

    Integer findCount();

    boolean delBatch(int[] ids);
}
