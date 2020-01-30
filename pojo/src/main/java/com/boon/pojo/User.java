package com.boon.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private String sno;          // 学号   主键
  private String name;         // 姓名
  private String password;     // 密码
  private String phone;        // 电话号码
  private String gender;       // 性别
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private java.sql.Timestamp birthday;   // 出生日期   以时间戳的方式保存
  private String qq;           // QQ号
  private String picture;      // 头像照片  存一个字符串
  private String signature;    // 个性签名
  private Integer state;       // 用户状态  1表示启用 0表示禁用
  private Integer del;         // 用户是否被删除 1表示删除 其他表示未删除

  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday == null? new Timestamp(0) :birthday;
  }

  public Integer getState() {

    /*设置state的默认值为1*/
    if("".equals(state)||state==null){
      return 1;
    }

    return state;
  }

  public void setState(Integer state) {
    this.state = state == 0 ? 0 : state;
  }

  public Integer getDel() {

    if("".equals(del)||del==null){
      return 0;
    }
    return del;
  }

  public void setDel(Integer del) {
    this.del = del == 0 ? 0 :del;
  }
}
