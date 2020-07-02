package com.boon.user;

import com.boon.user.utils.FDfsUtils;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

/**
 * author:       HeJin
 * Date:         2020/4/27
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FDfsTest {

    @Test
    public void upload() throws FileNotFoundException {

        StringBuffer stringBuffer = FDfsUtils.upLoad("D:\\项目资源\\html框架\\boon\\images\\background1.jpg");

        System.out.println(stringBuffer);
    }
}
