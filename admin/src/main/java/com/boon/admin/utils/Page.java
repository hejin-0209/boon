package com.boon.admin.utils;

import java.io.Serializable;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/5/20
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class Page<T> implements Serializable {
    private int pageNum;        //  当前页码
    private int pageSize;       //  每页条数
    private List<T> list;       //  需要分页的数据
    private int total;          //  数据总条数
    private int pageTotel;      //  页面总数

    public Page(){

    }

    public Page(List<T> list){
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = this.getList().size();
    }

    public int getPageTotel() {
        return pageTotel;
    }

    public void setPageTotel(int pageTotel) {
        this.pageTotel = ((int) this.getList().size() / this.pageSize)+1;
    }
}
