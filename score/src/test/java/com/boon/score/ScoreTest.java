package com.boon.score;

import com.boon.pojo.Score;
import com.boon.score.mapper.ScoreMapper;
import com.boon.score.service.ScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/16
 * version:      1.0
 * Description:  对成绩服务的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScoreTest {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private ScoreService scoreService;

    @Test
    public void addScore(){
        Score score = new Score();
        score.setSno("2016901147");
        score.setCourseId(2);
        score.setScore(90);
        boolean b = scoreService.addScore(score);
        System.out.println(b);
    }

    @Test
    public void findAll(){
        List<Score> scores = scoreService.findAll();
        for (Score score : scores) {
            System.out.println(score);
        }
    }

    @Test
    public void findBySno(){
        List<Score> list = scoreMapper.findBySno("2016901133");
        for (Score score : list) {
            System.out.println(score);
        }
    }

    @Test
    public void findByCourseId(){
        List<Score> list = scoreMapper.findByCourseId(1);
        for (Score score : list) {
            System.out.println(score);
        }
    }

    @Test
    public void findCreditBySno(){
        Integer creditBySno = scoreMapper.findCreditBySno("2016901133");
        System.out.println(creditBySno);
    }

    @Test
    public void findLearnCreditBySno(){
        Integer creditBySno = scoreMapper.findLearnCreditBySno("2016901135");
        System.out.println(creditBySno);
    }

    @Test
    public void findTotalBySno(){
        Integer totalBySno = scoreMapper.findTotalBySno("2016901147");
        System.out.println(totalBySno);
    }

    //计算加权成绩
    @Test
    public void weightedScore(){
        Double weighted = weighted("2016901133");
        System.out.println(weighted);
    }

    public Double weighted(String sno){
        Integer total = scoreService.findTotalBySno(sno);
        Integer credit = scoreService.findLearnCreditBySno(sno);
        return (double)total/credit;
    }
}