package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 班费的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassFee implements Serializable {

  private Integer id;        // 班费的id  主键
  private double income;     // 班费的收入
  private double expend;     // 班费的支出
  private double money;      // 总的班费
  private String userSno;   // 用户的学号   用来查看是谁对班费进行操作
  private java.sql.Timestamp operationTime;    // 对班费操作的时间
  private String description;   // 班费的用途或者来源

}
