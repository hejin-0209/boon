package com.boon.inform.service.impl;

import com.boon.inform.mapper.InformMapper;
import com.boon.inform.service.InformService;
import com.boon.pojo.Inform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return informMapper.addInform(inform);
    }

    @Override
    public Inform findById(Integer id) {
        return informMapper.findById(id);
    }

    @Override
    public List<Inform> findAll() {
        return informMapper.findAll();
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
}
