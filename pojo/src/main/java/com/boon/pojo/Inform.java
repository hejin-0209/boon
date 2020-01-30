package com.boon.pojo;

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
  private java.sql.Timestamp createTime;   // 通知的创建时间
  private String userSno;   // 通知发布人的id
  private Integer del;      // 通知是否删除

  public Integer getDel() {

    if("".equals(del)||del==null){
      return 0;
    }
    return del;
  }

  public void setDel(Integer del) {
    this.del = del == 0 ? 0 :del;
  }

  public Timestamp getCreateTime() {
    if("".equals(createTime)||createTime == null){
      return new Timestamp(0);
    }
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime == new Timestamp(0) ? new Timestamp(0) : createTime ;
  }
}
