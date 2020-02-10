package com.boon.admin.service;

import com.boon.pojo.Score;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  成绩的服务层
 */
@FeignClient(value = "boon-zuul")
public interface IScoreService {

    /**
     * 成绩的添加
     * @param score
     * @return
     */
    @RequestMapping("boon/score-proxy/score/addScore")
    boolean addScore(@RequestBody Score score);

    /**
     * 成绩的全查
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findAll")
    List<Score> findAll();

    /**
     * 根据学号来查询成绩
     * @param sno
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findBySno/{sno}")
    List<Score> findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 根据课程号来查询成绩
     * @param courseId
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findByCourseId/{courseId}")
    List<Score> findByCourseId(@PathVariable(value = "courseId") int courseId);

    /**
     * 计算个人所通过的学分(需要输入学号)
     * @param sno
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findCreditBySno/{sno}")
    Integer findCreditBySno(@PathVariable(value = "sno") String sno);

    /**
     * 计算个人所修的学分(需要输入学号)
     * @param sno
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findLearnCreditBySno/{sno}")
    Integer findLearnCreditBySno(@PathVariable(value = "sno") String sno);

    /**
     * 计算个人所得的总学分绩（学分乘于分数的总和，需要输入学号）
     * @param sno
     * @return
     */
    @RequestMapping("boon/score-proxy/score/findTotalBySno/{sno}")
    Integer findTotalBySno(@PathVariable(value = "sno") String sno);
}
