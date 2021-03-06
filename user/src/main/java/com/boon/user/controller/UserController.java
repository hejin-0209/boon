package com.boon.user.controller;

import com.boon.pojo.User;
import com.boon.user.result.JsonResult;
import com.boon.user.service.RoleService;
import com.boon.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

/**
 * author:       HeJin
 * Date:         2019/12/23
 * version:      1.0
 * Description:  用户的控制层
 */
@RestController
@RequestMapping("user")
@Api(value = "用户的控制器")
public class  UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /*全查*/
    @GetMapping("findAll")
    @ApiOperation(value = "全查所有的用户")
    public List<User> findAll(){
        return userService.findAll();
    }

    /*增加用户*/
    @PostMapping("addUser")
    @ApiOperation(value = "添加一个用户",notes = "用户的信息可由表导入，也可以在后台管理中输入")
    public boolean addUser(@RequestBody User user){
        System.out.println("需要增加的用户是:"+user);
        return userService.addUser(user);
    }

    /*根据学号查询用户*/
    @GetMapping("findBySno/{sno}")
    @ApiOperation(value = "根据用户的学号来查询用户的信息",notes = "用户的Sno由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "用户的学号",
            required = true ,dataType = "String")
    public User findBySno(@PathVariable String sno){
        System.out.println("传进来的学号是:"+sno);
        return userService.findBySno(sno);
    }

    /*删除用户*/
    @DeleteMapping("deleteBySno/{sno}")
    @ApiOperation(value = "根据学号删除一个用户", notes = "用户的学号由前台输入")
    @ApiImplicitParam(paramType = "path" , name = "sno" ,value = "用户的学号",
            required = true ,dataType = "String")
    public boolean deleteBySno(@PathVariable String sno){

        return userService.deleteBySno(sno);
    }

    /*修改用户信息*/
    @PostMapping("update")
    @ApiOperation(value = "更新一个用户的信息",notes = "根据输入的内容来更新用户，在更新之前，需要先将用户查询出来")
    public boolean updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }

    /*查询用户数量*/
    @GetMapping("findCount")
    @ApiOperation(value = "查询用户数量",notes = "直接调用接口获取")
    public Integer findCount(){
        return userService.findCount();
    }

    /*修改用户状态*/
    @PostMapping("changeState/{sno}")
    public boolean changeState(@PathVariable(value = "sno") String sno){
        return userService.changeState(sno);
    }

    /*批量删除数据*/
    @DeleteMapping("delBatch/{snos}")
    public boolean delBatch(@PathVariable String[] snos){
        return userService.delBatch(snos);
    }

    /* 全查用户，分页 */
    @GetMapping("findUser")
    public JsonResult findUser(int page,int limit){
        return userService.findUser(page,limit);
    }

    /* 查询已删除的用户 */
    @GetMapping("findDelete")
    public List<User> findDelete(){
        return userService.findDelete();
    }

    /* 修改删除状态 */
    @PostMapping("changeDel/{sno}")
    public boolean changeDel(@PathVariable String sno){
        return userService.changeDel(sno);
    }

    /* 批量恢复删除 */
    @PostMapping("restoreBatch/{snos}")
    public boolean restoreBatch(@PathVariable String[] snos){
        return userService.restoreBatch(snos);
    }

    /* 查找权限 */
    @PostMapping("findRightByUserSno")
    public Set<String> findRightByUserSno(@RequestBody User user){
        return userService.findRightByUserSno(user.getSno());
    }

    /* 查找角色 */
    @PostMapping("findRoleNameByUserSno")
    public Set<String> findRoleNameByUserSno(@RequestBody User user){
        return roleService.findRoleNameByUserSno(user.getSno());
    }

    /*获取管理员的数量*/
    @ApiOperation(value = "获取管理员的数量")
    @GetMapping("findAdminCount")
    public Integer findAdminCount(){
        return userService.findAdminCount();
    }

    /*批量导入用户*/
    @PostMapping("bulkImport")
    public Integer bulkImport(MultipartFile file) throws  Exception{
        System.out.println("课程："+file);
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());//创建Excel,读取文件内容
        //读取文件第一个sheet文件
        XSSFSheet sheet = workbook.getSheetAt(0);//通过下标获取文件，第一页
        int firstRowNum = 1; // 开始读取数据的行数
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum()+1;
        User user = new User();
        int x = 0;      // 计时器
        for (int i = firstRowNum; i < lastRowNum; i++) {
                    XSSFRow row = sheet.getRow(i);
                    //获取行内单元格号
                    int lastCellNum = row.getLastCellNum();
                    for (int j = 0; j < lastCellNum; j+=2) {
                        Cell cell = row.getCell(j);
                        Cell cell1 = row.getCell(j+1);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        user.setSno(cell.getStringCellValue());
                        user.setName(cell1.getStringCellValue());
                    }
                    boolean b = userService.addUser(user);
                    if (b){
                x ++;
            }
        }
        if (lastRowNum == x+1){
            return 1;
        }
        return 0;
    }

    @PostMapping("uploadPhoto")
    public boolean uploadPhoto(@RequestBody User user){
        System.out.println("需要修改头像的用户是："+user.getSno());
        return userService.uploadPhoto(user);
    }

}
