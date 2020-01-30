package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 卫生体育表的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health implements Serializable {

  private String sno;         // 学号作为卫生体育表的主键
  private Integer physique;     // 身体健康状况
  private Integer hygiene;    // 卫生情况
  private Integer exercise;   // 锻炼情况
  private Integer labour;     // 劳动情况
  private String rewardsSno; // 奖惩中的学号
  private double proportion;  // 卫生体育表在综测中的占比

}
