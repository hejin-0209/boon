package com.boon.user;

import com.boon.pojo.User;
import com.boon.user.mapper.UserMapper;
import com.boon.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void findAll(){
        List<User> users = userMapper.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }

    /*增加用户*/
    @Test
    public void addUser(){
        User user = new User();
        user.setSno("2016901135");
        user.setName("易俊涛");
        user.setPassword(user.getSno().substring(4));
        boolean b = userMapper.addUser(user);
        if(b){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }

    /*根据学号查询用户*/
    @Test
    public void findBySno(){
        String sno = "2016901147";
        User user = userMapper.findBySno(sno);
        if(user!=null){
            if(user.getState()!=1){
                System.out.println("账号已禁用，请联系管理员");
            }else{
                System.out.println(user);
            }
        }else {
            System.out.println("该用户不存在！");
        }
    }

    /*删除用户*/
    @Test
    public void deleteBySno(){
        String sno = "2016901133";
        boolean b = userService.deleteBySno(sno);
        System.out.println(b);
    }

    /*更新用户数据*/
    @Test
    public void updateUser(){
        String sno = "2016901147";
        User user = userMapper.findBySno(sno);
        System.out.println(user);
        user.setPassword("123456");
        System.out.println(user);
        boolean b = userService.updateUser(user);
        System.out.println(b);
    }


}
