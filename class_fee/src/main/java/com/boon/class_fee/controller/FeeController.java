package com.boon.class_fee.controller;

import com.boon.class_fee.service.FeeService;
import com.boon.pojo.ClassFee;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/19
 * version:      1.0
 * Description:  班费的控制层
 */
@RestController
@RequestMapping("fee")
@Api(value = "班费的接口")
public class FeeController {

    @Autowired
    private FeeService feeService;

    //增加班费的管理
    @PostMapping("addFee")
    @ApiOperation(value = "增加帮费的管理", notes = "需要提供一个ClassFee类的对象")
    public boolean addFee(@RequestBody ClassFee fee) {
        return feeService.addFee(fee);
    }

    //查询班费还有多少
    @GetMapping("findMoney")
    @ApiOperation(value = "查询剩余的班费", notes = "直接调用这个接口即可查询剩余逇班费")
    public Double findMoney() {
        return feeService.findMoney();
    }

    // 班费管理的更新
    @GetMapping("updateFee")
    @ApiOperation(value = "班费管理的更新", notes = "需要提供一个ClassFee类的对象")
    public boolean updateFee(ClassFee fee) {
        return feeService.updateFee(fee);
    }

    // 根据id查询班费管理
    @GetMapping("findById/{id]")
    @ApiOperation(value = "根据id来查询班费管理", notes = "需要在前台输入所需要查询的id")
    @ApiImplicitParam(paramType = "path", name = "id", value = "班费的id",
            required = true, dataType = "int")
    public ClassFee findById(@PathVariable int id) {
        return feeService.findById(id);
    }

    // 根据学号来查询所管理的班费
    @GetMapping("findBySno/{sno}")
    @ApiOperation(value = "根据学号来查询所管理的班费", notes = "需要提供管理者的学号")
    @ApiImplicitParam(paramType = "path", name = "sno", value = "管理者的学号",
            required = true, dataType = "String")
    public List<ClassFee> findBySno(@PathVariable String sno) {
        return feeService.findBySno(sno);
    }

    // 查询所有的班费情况
    @GetMapping("findFee/{page}/{sno}/{startTime}/{endTime}")
    @ApiOperation(value = "查询所有的班费使用情况", notes = "需要条件查询的请输入条件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "sno", value = "管理者的学号",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页面",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "startTime", value = "开始时间",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "endTime", value = "结束时间",
                    required = true, dataType = "String"),
    })
    public PageInfo<ClassFee> findFee(@PathVariable(value = "page") String page, @PathVariable(value = "sno") String sno,
                                          @PathVariable(value = "startTime") String startTime, @PathVariable(value = "endTime") String endTime) {

        System.out.println("传进来的数据：学号--" + sno + " 开始时间--" + startTime + " 结束时间--" + endTime);
        Timestamp sTime = null;
        Timestamp eTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("null".equals(sno)) {
            sno = null;
        }
        try {
            if ("null".equals(startTime)) {
                sTime = null;
            } else {
                sTime = new Timestamp(sdf.parse(startTime).getTime());
            }
            if ("null".equals(endTime)) {
                eTime = null;
            } else {
                eTime = new Timestamp(sdf.parse(endTime).getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 分页，后端规定每页10条数据
        PageHelper.startPage(Integer.valueOf(page), 10);
        PageInfo<ClassFee> info = new PageInfo<>(feeService.findFee(sno, sTime, eTime));
        System.out.println("页面信息是：" + info);
        return info;
    }
}
