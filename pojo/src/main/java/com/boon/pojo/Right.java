package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 权限的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Right implements Serializable {

  private Integer id;        // 权限id  主键
  private String name;       // 权限名字
  private Integer parentId;  // 权限的父类id  用于权限表的无限分类
  private String url;       // 权限的代码块

}
