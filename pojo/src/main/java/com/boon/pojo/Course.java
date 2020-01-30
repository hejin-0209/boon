package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程的主键
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course  implements Serializable {

  private Integer id;     // 课程的id（编号）  主键
  private String name;    // 课程的名字
  private Integer credit; // 课程的学分
  private Integer del = 0;    // 课程的删除状态 1表示删除，其他表示未删除
}
