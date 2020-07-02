package com.boon.pojo.vo;

import com.boon.pojo.Right;
import com.boon.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/17
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Serializable {

    private Role role;
    private List<Right> rights;
    private String[] ids;

}
