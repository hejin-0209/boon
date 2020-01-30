package com.boon.score.service.impl;

import com.boon.pojo.Score;
import com.boon.score.mapper.ScoreMapper;
import com.boon.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  成绩的服务层实现类
 */
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public boolean addScore(Score score) {
        return scoreMapper.addScore(score);
    }

    @Override
    public List<Score> findScore() {
        return scoreMapper.findScore();
    }

    @Override
    public List<Score> findBySno(String sno) {
        return scoreMapper.findBySno(sno);
    }

    @Override
    public List<Score> findByCourseId(int courseId) {
        return scoreMapper.findByCourseId(courseId);
    }

    @Override
    public Integer findCreditBySno(String sno) {
        return scoreMapper.findCreditBySno(sno);
    }

    @Override
    public Integer findLearnCreditBySno(String sno) {
        return scoreMapper.findLearnCreditBySno(sno);
    }

    @Override
    public Integer findTotalBySno(String sno) {
        return scoreMapper.findTotalBySno(sno);
    }
}
