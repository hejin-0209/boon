package com.boon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * author:       HeJin
 * Date:         2019/12/22
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class FileCopy {
    public static void main(String[] args) {
        System.out.println(
                "请输入源txt目录（程序将会自动将目录内" + "的所有txt文件复制到指定文件目录中），如：d:\\docs\\txt");
        Scanner sc = new Scanner(System.in);
        String srcpath = sc.nextLine();//txt源文件目录
        System.out.println(
                "请输入指定存储目录（程序将会自动将目录内" + "的所有txt文件复制到指定文件目录中），如：d:\\docs\\txt");
        String despath = sc.nextLine(); //txt要保存的制定目录
        File src = new File(srcpath); // 获取用书输入的目录
        File des = new File(despath);
        getTxt(src,des);
    }

    /*
     * 获取txt文件 ，函数
     */
    public static void getTxt(File src,File des) {
        if(!(des.exists())){
            des.mkdir();
        }
        File[] files = src.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                getTxt(files[i],des);
            } else {
                if(files[i].getName().endsWith("txt")||files[i].getName().endsWith("md")||files[i].getName().endsWith("ppt")) {
                    copyFile(files[i], new File(des, files[i].getName()));
                }
            }
        }
    }
    /* * 复制文件函数 */
    public static void copyFile(File src, File des) {

        // 获取系统当前毫秒级时间
        long s = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(des);
            // 创建缓冲数组
            byte[] bytes = new byte[1024];
            // 读取文件个数len
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException ex) {
            System.out.println(ex);
            throw new RuntimeException("复制文件失败！");
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {
                System.out.println(ex);
                throw new RuntimeException("fos释放资源失败！");
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                }catch (IOException ex) {
                    System.out.println(ex);
                    throw new RuntimeException("fis释放资源失败！");
                }
            }
        }

        long e = System.currentTimeMillis();
        System.out.print("复制文件" + src.getName() + "耗费时间(毫秒级)为：");
        System.out.println(e - s);
    }

}
