package com.boon.pojo.vo;

import com.boon.pojo.Right;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/19
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RightDto implements Serializable {

    // 父类的权限
    private Right parent;
    // 父类对应的子类权限
    private List<Right> childs;
}
