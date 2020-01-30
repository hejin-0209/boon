package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 思想品德表的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moral implements Serializable {

  private String sno;          // 学生在思想品德表中的学号  主键
  private Integer politics;    // 政治思想
  private Integer learn;       // 学习态度
  private Integer culture;     // 文明礼貌
  private Integer discipline;  // 纪律观念
  private String rewardsSno;  // 奖惩中的学号
  private double proportion;   // 思想品德表在综测中的占比

}
