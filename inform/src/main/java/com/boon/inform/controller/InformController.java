package com.boon.inform.controller;

import com.boon.inform.service.InformService;
import com.boon.pojo.Inform;
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
 * Date:         2020/1/23
 * version:      1.0
 * Description:  通知的控制层
 */
@RestController
@RequestMapping("inform")
@Api(value = "通知的接口")
public class InformController {

    @Autowired
    private InformService informService;

    // 增加通知
    @PostMapping("addInform")
    @ApiOperation(value = "新增通知" , notes = "通知的信息需要在前台输入")
    public boolean addInform(@RequestBody Inform inform){
        return informService.addInform(inform);
    }

    // 通过id查询通知
    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据id查找一个通知" , notes = "需要提供一个通知的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "通知的id",
            required = true ,dataType = "int")
    public Inform findById(@PathVariable Integer id){
        return informService.findById(id);
    }

    // 查询所有的通知
    @GetMapping("findAll/{page}/{sno}/{title}/{startTime}/{endTime}")
    @ApiOperation(value = "查询所有的通知",notes = "需要条件查询的请输入条件")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "sno", value = "管理者的学号",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "title", value = "标题",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页面",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "startTime", value = "开始时间",
                    required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "endTime", value = "结束时间",
                    required = true, dataType = "String"),
    })
    public PageInfo<Inform> findAll(@PathVariable("page") String page, @PathVariable("sno") String sno, @PathVariable("title") String title,
                                    @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime){
        System.out.println("传进来的数据：学号--" + sno + "标题--" + title + " 开始时间--" + startTime + " 结束时间--" + endTime);
        Timestamp sTime = null;
        Timestamp eTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if ("null".equals(sno)) {
            sno = null;
        }
        if ("null".equals(title)) {
            title = null;
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
        PageInfo<Inform> info = new PageInfo<>(informService.findAll(sno,title, sTime, eTime));
        System.out.println("页面信息是：" + info);
        return info;
    }

    // 通过管理员的学号来查询通知
    @GetMapping("findBySno/{userSno}")
    @ApiOperation(value = "通过管理员的学号来查询id" ,notes = "需要提供管理员的学号")
    @ApiImplicitParam(paramType = "path" , name = "userSno" ,value = "管理员的学号",
            required = true ,dataType = "String")
    public List<Inform> findBySno(@PathVariable String userSno){
        return informService.findBySno(userSno);
    }

    // 更新通知
    @PostMapping("update")
    @ApiOperation(value = "更新通知" , notes = "需要更新的内容需要在前台输入")
    public boolean update(@RequestBody Inform inform){
        return informService.update(inform);
    }

    // 删除通知
    @GetMapping("delete/{id}")
    @ApiOperation(value = "删除一个通知" , notes = "不是真正的删除，而是将Del字段的值改为1，需要提供通知的id")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "通知的id",
            required = true ,dataType = "int")
    public boolean delete(@PathVariable Integer id){
        return informService.delete(id);
    }

    /* 查询通知的数量 */
    @GetMapping("findCount")
    @ApiOperation(value = "查询通知的数量", notes = "直接调用接口获取数据")
    public Integer findCount(){
        return informService.findCount();
    }
}
