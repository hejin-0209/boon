package com.boon.admin.common.dto;

import com.boon.pojo.Logs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Timestamp;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/3/12
 * version:      1.0
 * Description:  关于这个类的描述
 */
@Mapper
public interface LogMapper {

    @Insert("insert into logs values(null,#{userSno},#{module},#{flag},#{remark},now())")
    void save(Logs logs);

    @Select("select * from logs where userSno = #{userSno} and module in ('用户登录','用户退出') ORDER BY id DESC LIMIT 6")
    List<Logs> userLogs(String sno);

    @Select("<script>" +
            "SELECT l.* , u.`name` userName from\n" +
            "        logs l INNER JOIN `user` u ON l.userSno = u.sno WHERE u.del = 0\n" +
            "        <if test=\"name != null and name != ''\">\n" +
            "            and u.name = #{name}\n" +
            "        </if>\n" +
            "        <if test=\"sno != null and sno != ''\">\n" +
            "            and l.userSno = #{sno}\n" +
            "        </if>\n" +
            "        <if test=\"module != null and module != ''\">\n" +
            "            and l.module LIKE CONCAT(CONCAT('%',#{module}),'%')   /*根据标题模糊查询，concat用于拼接字符创串*/\n" +
            "        </if>\n" +
            "        <if test=\"startTime != null\">\n" +
            "            and UNIX_TIMESTAMP(l.createTime) &gt; UNIX_TIMESTAMP(#{startTime})\n" +
            "        </if>\n" +
            "        <if test=\"endTime != null\">\n" +
            "            and UNIX_TIMESTAMP(l.createTime) &lt; UNIX_TIMESTAMP(#{endTime})\n" +
            "        </if>" +
            "ORDER BY id DESC" +
            "</script>")
    List<Logs> findAll(@Param("sno") String sno,@Param("name") String name,@Param("module") String module,
                       @Param("startTime") Timestamp startTime,@Param("endTime") Timestamp endTime);
}
