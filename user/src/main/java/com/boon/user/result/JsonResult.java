package com.boon.user.result;

import com.boon.pojo.User;
import lombok.Data;

import java.util.List;


/**
 * author:       HeJin
 * Date:         2020/2/21
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Data
public class JsonResult {

    // 响应的状态码
    private Integer code;

    // 响应的消息
    private String msg;

    private long count;

    private List<User> data;
}
