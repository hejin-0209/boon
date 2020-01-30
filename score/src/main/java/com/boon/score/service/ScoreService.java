package com.boon.score.service;

import com.boon.pojo.Score;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  成绩的服务层
 */
public interface ScoreService {

    boolean addScore(Score score);

    List<Score> findScore();

    List<Score> findBySno(String sno);

    List<Score> findByCourseId(int courseId);

    Integer findCreditBySno(String sno);

    Integer findLearnCreditBySno(String sno);

    Integer findTotalBySno(String sno);
}
