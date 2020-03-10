package com.boon.admin.controller;

import com.boon.admin.service.IScoreService;
import com.boon.pojo.Score;
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
@RequestMapping("score")
public class ScoreController {

    @Autowired
    private IScoreService scoreService;

    //成绩的添加
    @PostMapping("addScore")
    public boolean addScore(@RequestBody Score score){
        return scoreService.addScore(score);
    }

    //成绩的全查
    @GetMapping("findAll")
    public List<Score> findAll(){
        return scoreService.findAll();
    }

    //根据学号来查询成绩
    @GetMapping("findBySno/{sno}")
    public List<Score> findBySno(@PathVariable String sno){
        return scoreService.findBySno(sno);
    }

    //根据课程号来查询成绩
    @GetMapping("findByCourseId/{courseId}")
    public List<Score> findByCourseId(@PathVariable int courseId){
        return scoreService.findByCourseId(courseId);
    }

    //计算个人所通过的学分(需要输入学号)
    @GetMapping("findCreditBySno/{sno}")
    public Integer findCreditBySno(@PathVariable String sno){
        return scoreService.findCreditBySno(sno);
    }

    //计算个人所修的学分(需要输入学号)
    @GetMapping("findLearnCreditBySno/{sno}")
    public Integer findLearnCreditBySno(@PathVariable String sno){
        return scoreService.findLearnCreditBySno(sno);
    }

    //计算个人所得的总学分绩（学分乘于分数的总和，需要输入学号）
    @GetMapping("findTotalBySno/{sno}")
    public Integer findTotalBySno(@PathVariable String sno){
        return scoreService.findTotalBySno(sno);
    }

    // 计算加权成绩
    @GetMapping("weightedScore/{sno}")
    public Double weightedScore(@PathVariable String sno){
        Integer total = scoreService.findTotalBySno(sno);
        Integer credit = scoreService.findLearnCreditBySno(sno);
        return (double)total/credit;
    }

    // 成绩和课程的联合查询
    @PostMapping("findScore/{sno}/{courseId}/{minScore}/{maxScore}")
    public List<Score> findScore(@PathVariable(value = "sno") String sno, @PathVariable(value = "courseId") String courseId,
                                 @PathVariable(value = "minScore") String minScore, @PathVariable(value = "maxScore") String maxScore) {
        return scoreService.findScore(sno,courseId,minScore,maxScore);
    }

    // 批量删除
    @PostMapping("delBatch/{ids}")
    public boolean delBatch(@PathVariable(value = "ids")int[] ids){
        return scoreService.delBatch(ids);
    }

    // 根据id查询成绩
    @GetMapping("findById/{id}")
    public Score findById(@PathVariable(value = "id") Integer id){
        return scoreService.findById(id);
    }

    // 更新成绩
    @PostMapping("update")
    public boolean update(@RequestBody Score score){
        return scoreService.update(score);
    }

    // 成绩删除
    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable(value = "id") Integer id){
        return scoreService.delete(id);
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
