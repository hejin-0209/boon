package com.boon.admin.confing;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * author:       HeJin
 * Date:         2019/12/2
 * version:      1.0
 * Description:  这是关于fastDfs的配置文件
 */
@Configuration
@Import(FdfsClientConfig.class)
// 解决jimx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastClientImporter {
}
