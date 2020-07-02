package com.boon.pojo.vo;

import com.boon.pojo.Role;
import com.boon.pojo.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * author:       HeJin
 * Date:         2020/3/16
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo extends UserRole implements Serializable {

    private String userName;        // 角色对应的用户名（来自用户表）
    private String userPhone;       // 角色对应的用户手机号（来自用户表）
    private String name;            // 角色的名字
    private String description;     // 角色的描述

}
