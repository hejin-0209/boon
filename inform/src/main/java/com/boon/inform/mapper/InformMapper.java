package com.boon.inform.mapper;

import com.boon.pojo.Inform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的持久层
 */
@Mapper
public interface InformMapper {

    boolean addInform(Inform inform);

    Inform findById(Integer id);

    List<Inform> findAll();

    List<Inform> findBySno(String userSno);

    boolean update(Inform inform);

}
