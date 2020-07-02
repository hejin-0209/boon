package com.boon.pojo.vo;

import lombok.Data;

import java.io.InputStream;
import java.io.Serializable;

/**
 * author:       HeJin
 * Date:         2020/5/12
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Data
public class FileDto  implements Serializable {

    private InputStream inputStream;

}
