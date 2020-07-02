package com.boon.score.service.impl;

import com.boon.pojo.Score;
import com.boon.score.mapper.ScoreMapper;
import com.boon.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
    public List<Score> findAll() {
        return scoreMapper.findAll();
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
        Integer credit = scoreMapper.findCreditBySno(sno);
        if(credit == null){
            return 0;
        }
        return credit;
    }

    @Override
    public Integer findLearnCreditBySno(String sno) {
        Integer learnCredit = scoreMapper.findLearnCreditBySno(sno);
        if(learnCredit == null){
            return 0;
        }
        return learnCredit;
    }

    @Override
    public Integer findTotalBySno(String sno) {
         return scoreMapper.findTotalBySno(sno);
    }

    @Override
    public List<Score> findScore(String sno, Integer courseId, Integer minScore, Integer maxScore) {
        return scoreMapper.findScore(sno,courseId,minScore,maxScore);
    }

    @Override
    public boolean delBatch(int[] ids) {
        int i = 0;
        for (Integer id : ids) {
            Score score = scoreMapper.findById(id);
            score.setDel(1);
            boolean b = update(score);
            if(b){
                i++;
            }
        }
        if (i == ids.length){
            return true;
        }
        return false;
    }

    @Override
    public Score findById(Integer id) {
        return scoreMapper.findById(id);
    }

    @Override
    public boolean update(Score score) {
        return scoreMapper.update(score);
    }

    @Override
    public boolean delete(Integer id) {
        Score score = scoreMapper.findById(id);
        score.setDel(1);
        boolean b = scoreMapper.update(score);
        return b;
    }
}
