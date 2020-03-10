package com.boon.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 奖惩表的实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rewards implements Serializable {

    private Integer id;           // 奖惩的id  主键
    private String sno;           // 学生在奖惩表中的学号
    private Integer typeId;       // 奖惩所属的类别ID
    private Integer initialValue; // 奖惩的初始值
    private Integer reward;        // 奖励
    private Integer punish;       // 惩罚
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp createTime;   // 奖惩的创建时间
    private String description;      // 对奖惩的一个描述
    private Integer finalValue;   // 奖惩的最终值

    private String typeName;      // 将类型名作为扩展字段
    private String userName;      // 将用户名作为扩展字段
}
