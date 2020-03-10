package com.boon.reward;

import com.boon.pojo.Type;
import com.boon.reward_and_punishment.RewardApplication;
import com.boon.reward_and_punishment.mapper.TypeMapper;
import com.boon.reward_and_punishment.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/28
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RewardApplication.class)
public class TypeTest {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void addType(){
        Type type = new Type();
        type.setName("test");
        type.setAlias("测试分类");
        type.setParentId(0);
        System.out.println(type);
        boolean b = typeService.addType(type);
        System.out.println(b);
    }

    @Test
    public void findById(){
        Type type = typeService.findById(10);
        System.out.println(type);
    }

    @Test
    public void findAll(){
        List<Type> all = typeService.findAll();
        for (Type type : all) {
            System.out.println(type);
        }
    }

    @Test
    public void findParentId(){
        List<Type> types = typeService.findParentId(0);
        for (Type type : types) {
            System.out.println(type);
        }
    }

    @Test
    public void update(){
        Type type = typeService.findById(1);
        type.setParentId(2);
        boolean b = typeService.update(type);
        System.out.println(b);
    }

    @Test
    public void delete(){
        boolean b = typeService.delete(10);
        System.out.println(b);
    }

    @Test
    public void test1() {
        String str = "123";
        int x = 0;
        for (int i = str.length(); --i >= 0; ) {
            if (Character.isDigit(str.charAt(i))) {
                x++;
            }
        }
        if(x == str.length()){
            System.out.println("是数字");
        }else{
            System.out.println("是中文");
        }
    }

}
