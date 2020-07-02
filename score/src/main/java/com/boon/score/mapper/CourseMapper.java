package com.boon.score.mapper;

import com.boon.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的持久层
 */
@Mapper
public interface CourseMapper {
    //新增课程
    boolean addCourse(Course course);
    //查询所有的课程
    List<Course> findCourse();

    Course findById(int id);

    boolean update(Course course);

    Integer findCount();
}
