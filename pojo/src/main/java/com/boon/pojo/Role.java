package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

  private Integer id;          // 角色id  主键
  private String name;         // 角色名字
  private String description;  // 角色的描述


}
