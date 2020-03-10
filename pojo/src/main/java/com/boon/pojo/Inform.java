package com.boon.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 通知的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inform {

    private Integer id;       // 通知的id  主键
    private String title;     // 通知的标题
    private String content;   // 通知的主体
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp createTime;   // 通知的创建时间
    private String userSno;   // 通知发布人的id
    private Integer del;      // 通知是否删除

    private String userName;  // 将用户名作为通知的扩展字段

}
