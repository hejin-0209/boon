package com.boon.inform.service.impl;

import com.boon.inform.mapper.InformMapper;
import com.boon.inform.service.InformService;
import com.boon.pojo.Inform;
import org.bouncycastle.asn1.x509.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的服务层的实现类
 */
@Service
public class InformServiceImpl implements InformService {

    @Autowired
    private InformMapper informMapper;

    @Override
    public boolean addInform(Inform inform) {
        inform.setDel(0);
        return informMapper.addInform(inform);
    }

    @Override
    public Inform findById(Integer id) {
        return informMapper.findById(id);
    }

    @Override
    public List<Inform> findAll(String sno, String title, Timestamp startTime, Timestamp endTime) {
        String name = null;
        int x = 0;
        if(sno != null){
            for (int i = sno.length(); --i >= 0; ) {
                if (Character.isDigit(sno.charAt(i))) {
                    x++;
                }
            }
            if(x != sno.length()){
                name = sno;
                sno = null;
            }
        }
        System.out.println("传进来的数据是："+ sno + name + title + startTime + endTime);
        return informMapper.findAll(sno,name,title,startTime,endTime);
    }

    @Override
    public List<Inform> findBySno(String userSno) {
        return informMapper.findBySno(userSno);
    }

    @Override
    public boolean update(Inform inform) {
        return informMapper.update(inform);
    }

    @Override
    public boolean delete(Integer id) {
        Inform inform = informMapper.findById(id);
        inform.setDel(1);
        return informMapper.update(inform);
    }

    @Override
    public Integer findCount() {
        return informMapper.findCount();
    }
}
