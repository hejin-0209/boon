package com.boon.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限的关联类
 */

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleRight implements Serializable {

  private long id;        // 角色权限类的id
  private long roleId;    // 角色的id（主键）
  private long rightId;   // 权限的id（主键）

}
