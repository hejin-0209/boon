package com.boon.user.utils;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * author:       HeJin
 * Date:         2020/4/27
 * version:      1.0
 * Description:  关于这个类的描述
 */
public class FDfsUtils {
    @Autowired
    private static FastFileStorageClient storageClient;

    @Autowired
    private static ThumbImageConfig thumbImageConfig;

    // 普通的图片上传
    public static StringBuffer upLoad(String filePath) throws FileNotFoundException {
        StringBuffer fDfsPath = new StringBuffer("http://39.108.98.95:8080/");
        System.out.println("传过来的地址是："+filePath);
        File file = new File(filePath);
        StorePath storePath = storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        System.out.println("带分组的路径："+storePath.getFullPath());
        fDfsPath.append(storePath.getFullPath());
        System.out.println("追加之后的路径为："+fDfsPath);
        return fDfsPath;
    }

    // 带缩略图的图片上传（返回缩略图）
    public static StringBuffer uploadAndCreateThumb(String filePath) throws FileNotFoundException{
        StringBuffer fDfsPath = new StringBuffer("http://39.108.98.95:8080/");
        File file = new File(filePath);  // 文件的上传路径
        // 上传并且生成缩略图
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "jpg", null);
        fDfsPath.append(thumbImageConfig.getThumbImagePath(storePath.getPath()));

        // 打印缩略图在fastDfs中的路径（带分组）
        System.out.println(fDfsPath);
        return fDfsPath;
    }

//    public static StringBuffer upLoad2(String filePath) throws FileNotFoundException {
//        StringBuffer fDfsPath = new StringBuffer("http://39.108.98.95:8080/");
//        File file = new File(filePath);
//        StorePath storePath = storageClient.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
//        System.out.println("带分组的路径是："+storePath.getFullPath());
//        fDfsPath.append(storePath.getFullPath());
//        System.out.println("追加之后的路径为："+fDfsPath);
//        return fDfsPath;
//    }
}
