package com.boon.score.controller;

import com.boon.pojo.Score;
import com.boon.reward_and_punishment.service.CapacityService;
import com.boon.reward_and_punishment.service.HealthService;
import com.boon.reward_and_punishment.service.MoralService;
import com.boon.score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  成绩的控制器
 */
@RestController
@RequestMapping("Score")
@Api(value = "成绩的接口")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //成绩的添加
    @PostMapping("addScore")
    @ApiOperation(value = "成绩的添加" ,notes = "成绩需要管理员从后台输入")
    public boolean addScore(Score score){
        return scoreService.addScore(score);
    }

    //成绩的全查
    @GetMapping("findScore")
    @ApiOperation(value = "查询所有的成绩")
    public List<Score> findScore(){
        return scoreService.findScore();
    }

    //根据学号来查询成绩
    @PostMapping("findBySno/{sno}")
    @ApiOperation(value = "根据学号来查询成绩" ,notes = "需要提供学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "String")
    public List<Score> findBySno(@PathVariable String sno){
        return scoreService.findBySno(sno);
    }

    //根据课程号来查询成绩
    @PostMapping("findByCourseId/{courseId}")
    @ApiOperation(value = "根据课程号来查询成绩", notes = "需要提供课程号")
    @ApiImplicitParam(paramType = "path" , name = "courseId" ,value = "课程号",
            required = true ,dataType = "int")
    public List<Score> findByCourseId(@PathVariable int courseId){
        return scoreService.findByCourseId(courseId);
    }

    //计算个人所通过的学分(需要输入学号)
    @PostMapping("findCreditBySno/{sno}")
    @ApiOperation(value = "计算个人所通过的学分" ,notes = "需要提供学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "String")
    public Integer findCreditBySno(@PathVariable String sno){
        return scoreService.findCreditBySno(sno);
    }

    //计算个人所修的学分(需要输入学号)
    @PostMapping("findLearnCreditBySno/{sno}")
    @ApiOperation(value = "计算个人所修的学分" , notes = "需要提供学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "String")
    public Integer findLearnCreditBySno(@PathVariable String sno){
        return scoreService.findLearnCreditBySno(sno);
    }

    //计算个人所得的总学分绩（学分乘于分数的总和，需要输入学号）
    @PostMapping("findTotalBySno/{sno}")
    @ApiOperation(value = "计算个人所得的总学分绩（学分乘于分数的总和）" , notes = "需要提供学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "String")
    public Integer findTotalBySno(@PathVariable String sno){
        return scoreService.findTotalBySno(sno);
    }

    // 计算加权成绩
    @PostMapping("weightedScore/{sno}")
    @ApiOperation(value = "计算个人的加权成绩（总学分绩除以总学分）" , notes = "需要提供学号")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
            required = true ,dataType = "String")
    public Double weightedScore(@PathVariable String sno){
        Integer total = scoreService.findTotalBySno(sno);
        Integer credit = scoreService.findLearnCreditBySno(sno);
        return (double)total/credit;
    }

//    // 计算综测
//    @PostMapping("comprehensive/{sno}")
//    @ApiOperation(value = "计算个人的综测（学习成绩（60%）+思想品德（20%）+卫生体育（10%）+个人能力（10%））" , notes = "需要提供学号")
//    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "学生的学号",
//            required = true ,dataType = "String")
//    public Double comprehensive(@PathVariable String sno){
//        Double weightedScore = weightedScore(sno);
//        Double moralConvert = moralService.convert(sno);
//        Double healthConvert = healthService.convert(sno);
//        Double capacityConvert = capacityService.convert(sno);
//        double comprehensive = weightedScore * 0.6 + moralConvert + healthConvert + capacityConvert;
//        return comprehensive;
//    }

}
