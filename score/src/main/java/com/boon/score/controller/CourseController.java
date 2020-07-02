package com.boon.score.controller;

import com.boon.pojo.Course;
import com.boon.pojo.User;
import com.boon.pojo.vo.FileDto;
import com.boon.score.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/10
 * version:      1.0
 * Description:  课程的控制层
 */
@RestController
@RequestMapping("course")
@Api(value = "课程的接口")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /* 课程的增加 */
    @PostMapping("addCourse")
    @ApiOperation(value = "添加一门课程" ,notes = "课程的信息请在后台管理中输入")
    public boolean addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    /* 查询所有的课程 */
    @GetMapping("findCourse")
    @ApiOperation(value = "查询所有的课程")
    public List<Course> findCourse(){
        return courseService.findCourse();
    }

    /* 根据id查询 */
    @GetMapping("findById/{id}")
    @ApiOperation(value = "根据id查询一门课程",notes = "课程的id由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "课程的id",
            required = true ,dataType = "int")
    public Course findById(@PathVariable int id){
        return courseService.findById(id);
    }

    /* 修改课程的信息 */
    @PostMapping("update")
    @ApiOperation(value = "修改课程的信息" , notes = "课程的信息再后台管理中修改，然后提交到后台")
    public boolean update(@RequestBody Course course){
        return courseService.update(course);
    }

    /* 删除一个课程 */
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除一门课程" , notes = "这里的删除不是真删，而是将课程的del字段的值改为1")
    @ApiImplicitParam(paramType = "path" , name = "id" ,value = "课程的id",
            required = true ,dataType = "int")
    public boolean delete(@PathVariable int id){
        return courseService.delete(id);
    }

    /*查询课程的数量*/
    @GetMapping("findCount")
    @ApiOperation(value = "查询课程的数量",notes = "直接调用接口获取数据")
    public Integer findCount(){
        return courseService.findCount();
    }

    /* 批量删除课程 */
    @PostMapping("delBatch/{ids}")
    public boolean delBatch(@PathVariable(value = "ids") int[] ids){
        return courseService.delBatch(ids);
    }

    @PostMapping("bulkImport")
    public boolean bulkImport(MultipartFile file) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());//创建Excel,读取文件内容
        //读取文件第一个sheet文件
        //HSSFSheet sheet=workbook.getSheet("Sheet0");//通过文件名称获取
        XSSFSheet sheet = workbook.getSheetAt(0);//通过下标获取文件，第一页
        int firstRowNum = 1;
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum()+1;
        Course course = new Course();
        int x = 0;      // 计时器
        for (int i = firstRowNum; i < lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            //获取行内单元格号
            int lastCellNum = row.getLastCellNum();
            for (int j = 0; j < lastCellNum; j+=3) {
                Cell cell = row.getCell(j);
                Cell cell1 = row.getCell(j+1);
                Cell cell2 = row.getCell(j + 2);
                cell2.setCellType(Cell.CELL_TYPE_STRING);
                course.setName(cell.getStringCellValue());
                course.setTerm(cell1.getStringCellValue());
                course.setCredit(Integer.valueOf(cell2.getStringCellValue()));
            }
            boolean b = courseService.addCourse(course);
            if (b){
                x ++;
            }
        }
        if (lastRowNum == x+1){
            return true;
        }
        return false;
    }

}
