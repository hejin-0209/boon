package com.boon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  private Integer userId;   // 通知发布人的id
  private Integer del;      // 通知是否删除

}
