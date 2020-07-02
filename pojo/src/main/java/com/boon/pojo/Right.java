package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Right {

  private Integer id;            // 权限id
  private String name;        // 权限名字
  private Integer parentId;      // 权限父类
  private String url;         // 权限链接
  /**
   * 1： 菜单    2：按钮
   */
  private String type;        // 权限类别

}
