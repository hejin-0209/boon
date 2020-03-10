package com.boon.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp operationTime;    // 对班费操作的时间
    private String description;   // 班费的用途或者来源

    private String userName;      // 将用户名作为班费的扩展字段

}
