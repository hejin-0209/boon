package com.boon.admin.service;

import com.boon.pojo.Score;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "boon/score-proxy/score/addScore",method = RequestMethod.POST)
    boolean addScore(@RequestBody Score score);

    /**
     * 成绩的全查
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findAll",method = RequestMethod.GET)
    List<Score> findAll();

    /**
     * 根据学号来查询成绩
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findBySno/{sno}",method = RequestMethod.GET)
    List<Score> findBySno(@PathVariable(value = "sno") String sno);

    /**
     * 根据课程号来查询成绩
     * @param courseId
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findByCourseId/{courseId}",method = RequestMethod.GET)
    List<Score> findByCourseId(@PathVariable(value = "courseId") int courseId);

    /**
     * 计算个人所通过的学分(需要输入学号)
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findCreditBySno/{sno}",method = RequestMethod.GET)
    Integer findCreditBySno(@PathVariable(value = "sno") String sno);

    /**
     * 计算个人所修的学分(需要输入学号)
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findLearnCreditBySno/{sno}",method = RequestMethod.GET)
    Integer findLearnCreditBySno(@PathVariable(value = "sno") String sno);

    /**
     * 计算个人所得的总学分绩（学分乘于分数的总和，需要输入学号）
     * @param sno
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findTotalBySno/{sno}",method = RequestMethod.GET)
    Integer findTotalBySno(@PathVariable(value = "sno") String sno );

    /**
     * 课程和成绩的联合查询
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findScore/{sno}/{courseId}/{minScore}/{maxScore}",method = RequestMethod.POST)
    List<Score> findScore(@PathVariable(value = "sno") String sno, @PathVariable(value = "courseId") String courseId,
                          @PathVariable(value = "minScore") String minScore, @PathVariable(value = "maxScore") String maxScore);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/delBatch/{ids}",method = RequestMethod.POST)
    boolean delBatch(@PathVariable(value = "ids") int[] ids);

    /**
     * 根据id查询成绩
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/findById/{id}",method = RequestMethod.GET)
    Score findById(@PathVariable(value = "id") Integer id);

    /**
     * 更新成绩
     * @param score
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/update",method = RequestMethod.POST)
    boolean update(@RequestBody Score score);

    /**
     * 根据id删除成绩
     * @param id
     * @return
     */
    @RequestMapping(value = "boon/score-proxy/score/delete/{id}",method = RequestMethod.DELETE)
    boolean delete(@PathVariable(value = "id") Integer id);
}
