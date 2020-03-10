package com.boon.score.mapper;

import com.boon.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  成绩的持久层
 */
@Mapper
public interface ScoreMapper {
    boolean addScore(Score score);

    List<Score> findAll();

    List<Score> findBySno(String sno);

    List<Score> findByCourseId(int courseId);

    Integer findCreditBySno(String sno);

    Integer findLearnCreditBySno(String sno);

    Integer findTotalBySno(String sno);

    List<Score> findScore(@Param("sno") String sno, @Param("courseId") Integer courseId,
                          @Param("minScore") Integer minScore, @Param("maxScore") Integer maxScore);

    Score findById(Integer id);

    boolean update(Score score);
}
