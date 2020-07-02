package com.boon.admin.controller;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.common.enums.ResultStatusCode;
import com.boon.admin.common.vo.Result;
import com.boon.admin.service.*;
import com.boon.admin.utils.Page;
import com.boon.admin.utils.PageUtils;
import com.boon.admin.utils.UserUtil;
import com.boon.pojo.*;
import com.boon.pojo.vo.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;

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

    @Autowired
    private IUserService userService;           // 注入用户的service层

    @Autowired
    private MoralController moralController;         // 注入思想品德的controller层

    @Autowired
    private HealthController healthController;       // 注入卫生体育的controller层

    @Autowired
    private CapacityController capacityController;   // 注入个人能力的controller层

    //成绩的添加
    @LogAnnotation
    @ApiOperation("新增成绩")
    @PostMapping("addScore")
    @RequiresPermissions("/score/addScore")
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
        return scoreService.weightedScore(sno);
    }

    // 成绩和课程的联合查询
    @PostMapping("findScore/{sno}/{courseId}/{minScore}/{maxScore}")
    public List<Score> findScore(@PathVariable(value = "sno") String sno, @PathVariable(value = "courseId") String courseId,
                                 @PathVariable(value = "minScore") String minScore, @PathVariable(value = "maxScore") String maxScore) {
        return scoreService.findScore(sno,courseId,minScore,maxScore);
    }

    // 批量删除
    @LogAnnotation
    @ApiOperation("批量删除成绩")
    @PostMapping("delBatch/{ids}")
    @RequiresPermissions("/score/delBatch")
    public boolean delBatch(@PathVariable(value = "ids")int[] ids){
        return scoreService.delBatch(ids);
    }

    // 根据id查询成绩
    @GetMapping("findById/{id}")
    public Score findById(@PathVariable(value = "id") Integer id){
        return scoreService.findById(id);
    }

    // 更新成绩
    @LogAnnotation
    @ApiOperation("更新成绩")
    @PostMapping("update")
    @RequiresPermissions("/score/update")
    public boolean update(@RequestBody Score score){
        return scoreService.update(score);
    }

    // 成绩删除
    @LogAnnotation
    @ApiOperation("删除成绩")
    @DeleteMapping("delete/{id}")
    @RequiresPermissions("/score/delete")
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


    // 计算综测
    @GetMapping("comprehensives")
    public Result comprehensives(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit){
        //先将所有的用户查询出来
        List<User> users = userService.findAll();
        List<Comprehensive> comprehensives = new ArrayList<>();
        ArrayList<Double> sort = new ArrayList<>();
        for (User user : users) {
            Comprehensive comprehensive = new Comprehensive();
            if(user.getSno() != "admin"){
                // 这个人所有的成绩
                List<Score> scores = scoreService.findBySno(user.getSno());
                // 这个人所修的学分
                Integer credit = scoreService.findLearnCreditBySno(user.getSno());
                // 这个人的总学分绩
                Integer sum = scoreService.findTotalBySno(user.getSno());
                // 这个人的加权成绩
                Double weightedScore = weightedScore(user.getSno());
                // 这个人的思想品德分
                List<Moral> morals = moralController.findMoral(user.getSno());
                // 思想品德折合分
                Double moralConvert = moralController.convert(user.getSno());
                // 这个人的体育卫生分
                List<Health> healths = healthController.findHealth(user.getSno());
                // 体育卫生折合分
                Double healthConvert = healthController.convert(user.getSno());
                // 这个人的个人能力分
                List<Capacity> capacitys = capacityController.findCapacity(user.getSno());
                // 个人能力折合分
                Double capacityConvert = capacityController.convert(user.getSno());
                if(credit == null){
                    credit = 0;
                }
                if(weightedScore == null){
                    weightedScore = 0.0;
                }
                if(moralConvert == null){
                    moralConvert = 0.0;
                }
                if(healthConvert == null){
                    healthConvert = 0.0;
                }
                if(capacityConvert == null){
                    capacityConvert = 0.0;
                }
                comprehensive.setSno(user.getSno());
                comprehensive.setName(user.getName());
                Map<String, Integer> map = new HashMap<>();
                for (Score score : scores) {
                    if(score.getCourseName() != null && score.getCourseName() != "" && score.getScore() != null){
                        map.put(score.getCourseName(),score.getScore());
                    }
                }
                comprehensive.setScore(map);
                comprehensive.setCredit(credit);
                if(sum != null){
                    comprehensive.setSum(sum.doubleValue());
                }else {
                    comprehensive.setSum(0.0);
                }
                comprehensive.setWeightedScore(weightedScore);
                Double d = UserUtil.trim(weightedScore * 0.6);
                comprehensive.setScoreConvert(d);
                for (Moral moral : morals) {
                    comprehensive.setPolitics(moral.getPolitics());
                    comprehensive.setLearn(moral.getLearn());
                    comprehensive.setCulture(moral.getCulture());
                    comprehensive.setDiscipline(moral.getDiscipline());
                    comprehensive.setMoralReward(moral.getFinalRewards());
                }
                comprehensive.setMoralConvert(moralConvert);
                for (Health health : healths) {
                    comprehensive.setPhysique(health.getPhysique());
                    comprehensive.setHygiene(health.getHygiene());
                    comprehensive.setExercise(health.getExercise());
                    comprehensive.setLabour(health.getLabour());
                    comprehensive.setHealthReward(health.getFinalRewards());
                }
                comprehensive.setHealthConvert(healthConvert);
                for (Capacity capacity : capacitys) {
                    comprehensive.setBasic(capacity.getBasic());
                    comprehensive.setCapacityReward(capacity.getFinalRewards());
                }
                comprehensive.setCapacityConvert(capacityConvert);
                Double comprehensiveTotal = comprehensive.getScoreConvert()+moralConvert+healthConvert+capacityConvert;
                comprehensive.setComprehensiveTotal(UserUtil.trim(comprehensiveTotal));
                comprehensives.add(comprehensive);
            }
        }

        Collections.sort(comprehensives, new Comparator<Comprehensive>() {
            @Override
            public int compare(Comprehensive o1, Comprehensive o2) {
                if (o1.getComprehensiveTotal() > o2.getComprehensiveTotal()){
                    return -1;
                }
                if(o1.getComprehensiveTotal() == o2.getComprehensiveTotal()){
                    return 0;
                }
                return 1;
            }
        });

        for (Comprehensive comprehensive : comprehensives) {
            comprehensive.setSort(comprehensives.indexOf(comprehensive)+1);
        }
//        PageHelper.startPage(page,limit);
//        PageInfo<Comprehensive> info = new PageInfo<>(comprehensives);

        Page<Comprehensive> info = new Page<>();
        info.setList(comprehensives);
        Page<Comprehensive> pages = PageUtils.trim(page, limit, info);
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(0);
//        jsonResult.setMsg("成功");
//        jsonResult.setCount(info.getTotal());
//        jsonResult.setData(comprehensives);

        return new Result(ResultStatusCode.OK,pages);
    }

    @GetMapping("comprehensives1")
    public JsonResult comprehensives1(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit){
        Result comprehensives = comprehensives(page, limit);
        Page<Comprehensive> pages =(Page<Comprehensive>) comprehensives.getData();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(0);
        jsonResult.setMsg("成功");
        jsonResult.setCount(pages.getTotal());
        jsonResult.setData(pages.getList());
        return jsonResult;
    }

}

