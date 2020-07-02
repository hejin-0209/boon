package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * 综测的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comprehensive implements Serializable {

  private Integer sort;                    // 综测的排名
  private String sno;                      // 学生的学号
  private String name;                     // 学生的姓名
  private Map<String,Integer> score;       // 成绩的map
  private Integer credit;                  // 所选学分
  private Double sum;                      // 总学分绩
  private Double weightedScore;            // 加权成绩
  private Double scoreConvert;             // 成绩折合（60%）
  private Integer politics;                // 政治思想表现
  private Integer learn;                   // 学习态度
  private Integer culture;                 // 文明礼貌
  private Integer discipline;              // 纪律观念
  private Integer moralReward;             // 思想品德奖惩分
  private Double moralConvert;             // 思想品德折合（20%）
  private Integer physique;                // 身体健康情况
  private Integer hygiene;                 // 卫生情况
  private Integer exercise;                // 锻炼情况
  private Integer labour;                  // 劳动情况
  private Integer healthReward;            // 卫生体育奖惩分
  private Double healthConvert;            // 卫生体育折合（10%）
  private Integer basic;                   // 基本分
  private Integer capacityReward;          // 个人能力奖惩分
  private Double capacityConvert;          // 个人能力折合（10%）
  private Double comprehensiveTotal;       // 综测总分

}
