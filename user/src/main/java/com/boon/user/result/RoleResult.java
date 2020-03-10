package com.boon.user.result;

import com.boon.pojo.Role;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/3
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class RoleResult {

    // 响应的状态码
    private Integer code;

    // 响应的消息
    private String msg;

    private List<Role> data;
}
