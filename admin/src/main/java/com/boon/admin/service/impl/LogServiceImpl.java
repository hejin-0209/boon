package com.boon.admin.service.impl;

import com.boon.admin.common.dto.LogMapper;
import com.boon.admin.service.LogService;
import com.boon.admin.utils.UserUtil;
import com.boon.pojo.Logs;
import com.boon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/12
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(Logs logs) {
        User user = UserUtil.getCurrentUser();
        if (user == null || user.getSno() == null) {
            return;
        }

        logs.setUserSno(user.getSno());
        System.out.println("日志是："+logs);
        logMapper.save(logs);
    }

    @Override
    public List<Logs> userLogs(String sno) {
        return logMapper.userLogs(sno);
    }

    @Override
    public List<Logs> findAll(String sno, String module, Timestamp sTime, Timestamp eTime) {
        String name = null;
        System.out.println("sno是："+sno);
        if(sno != null){
            if(UserUtil.isChinese(sno)){
                name = sno;
                sno = null;
            }
        }
        System.out.println("传进来的数据是："+ sno + name + module + sTime + eTime);
        return logMapper.findAll(sno,name,module,sTime,eTime);
    }
}
