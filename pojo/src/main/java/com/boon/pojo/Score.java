package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 成绩表的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Score implements Serializable {

  private Integer id;       // 成绩的id  主键
  private String sno;       // 学生的学号
  private Integer courseId; // 课程的id  外键
  private Integer score;    // 成绩分数

}
