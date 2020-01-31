package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  个人能力的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capacity implements Serializable {

  private String sno;           // 学号作为个人能力表的主键
  private Integer basic;        // 个人能力表的基本值
  private String rewardsSno;   // 个人能力表的奖惩外键
  private double proportion;    // 个人能力表在综测中所占的比例

}
