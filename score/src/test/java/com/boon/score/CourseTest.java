package com.boon.score;

import com.boon.pojo.Course;
import com.boon.score.mapper.CourseMapper;
import com.boon.score.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/16
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseService courseService;

    @Test
    public void addCourse(){
        Course course = new Course(002, "office高级应用", 3,0);
//        System.out.println(courseMapper.addCourse(course));
        System.out.println(courseService.addCourse(course));
    }

    @Test
    public void findCourse(){
//        List<Course> courses = courseService.findCourse();
        List<Course> courses = courseMapper.findCourse();
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    @Test
    public void findById(){
//        System.out.println(courseService.findById(1));
        System.out.println(courseMapper.findById(2));
    }

    @Test
    public void update(){
        Course course = courseMapper.findById(3);
        course.setCredit(2);
        boolean bool = courseService.update(course);
        System.out.println(bool);
    }

    @Test
    public void delete(){
        boolean delete = courseService.delete(1);
        System.out.println(delete);
    }
}
