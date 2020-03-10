package com.boon.admin.controller;

import com.boon.admin.common.enums.ResultStatusCode;
import com.boon.admin.common.vo.Result;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/common")
@RestController
public class CommonController {

    /**
     * 未授权跳转方法
     * @return
     */
    @GetMapping("/unauth")
    public Result unauth(){
        SecurityUtils.getSubject().logout();
        return new Result(ResultStatusCode.UNAUTHO_ERROR);
    }

    @GetMapping("/unLogin")
    public Result unLogin(){
        return new Result(ResultStatusCode.UNLOGIN_ERROR);
    }

}
