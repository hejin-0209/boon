package com.boon.admin.utils;

import com.boon.pojo.Comprehensive;

import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/5/20
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class PageUtils {

    public static Page<Comprehensive> trim(int page, int limit, Page<Comprehensive> list){
        System.out.println("当前页："+page+",数量："+limit);
        list.setPageNum(page);
        list.setPageSize(limit);
        list.setTotal(list.getList().size());
        list.setPageTotel((int) list.getTotal() / list.getPageSize()+1);
        list.setList(list.getList().subList(limit*(page-1),limit*(page-1)+back(page,list.getPageTotel(),list.getTotal(),limit)));
        List<Comprehensive> list1 = list.getList();
        return list;
    }

    private static int back(int page,int pageTotal,int total,int limit){
        if(page == pageTotal){
            return (int) total - limit*(page - 1);
        }
        return (int) limit*page;
    }
}
