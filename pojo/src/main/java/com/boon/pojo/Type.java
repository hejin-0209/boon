package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类型表的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type implements Serializable {

  private Integer id;       // 类型的id  主键
  private String name;      // 类型的名字(英文)
  private String alias;     // 类型的别名(中文)
  private Integer parentId; // 类型的父亲id  用于类别表的无限分类

}
