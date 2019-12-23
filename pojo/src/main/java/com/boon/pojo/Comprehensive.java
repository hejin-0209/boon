package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 综测的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comprehensive implements Serializable {

  private Integer id;        // 综测的id  主键
  private String sno;        // 学号
  private String scoreSno;   // 成绩表中的学号
  private String moralSno;   // 思想品德表中的学号
  private String healthSno;  // 卫生体育表中的学号
  private String capacitySno;  // 个人能力表中的学号
  private double sum;        // 综测分数

}
