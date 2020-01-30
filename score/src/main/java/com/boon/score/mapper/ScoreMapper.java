package com.boon.score.mapper;

import com.boon.pojo.Score;
import org.apache.ibatis.annotations.Mapper;

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

    List<Score> findScore();

    List<Score> findBySno(String sno);

    List<Score> findByCourseId(int courseId);

    Integer findCreditBySno(String sno);

    Integer findLearnCreditBySno(String sno);

    Integer findTotalBySno(String sno);

}
