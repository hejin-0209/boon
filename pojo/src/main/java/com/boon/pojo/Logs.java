package com.boon.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logs {

  private long id;                //  日志的id
  private String userSno;         //  用户的学号
  private String module;          //  所属模块
  private boolean flag;              //  成功失败
  private String remark;          //  备注
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private java.sql.Timestamp createTime;      //  创建时间

  private String userName;        //  用户名作为日志的扩展字段

}
