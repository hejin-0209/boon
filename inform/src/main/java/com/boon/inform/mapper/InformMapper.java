package com.boon.inform.mapper;

import com.boon.pojo.Inform;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
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

    List<Inform> findAll(@Param("sno") String sno,@Param("name") String name,@Param("title") String title,
                         @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);

    List<Inform> findBySno(String userSno);

    boolean update(Inform inform);

    Integer findCount();

}
