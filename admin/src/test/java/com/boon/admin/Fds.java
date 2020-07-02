package com.boon.admin;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * author:       HeJin
 * Date:         2020/5/12
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class Fds {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload( ) throws FileNotFoundException {
        File file = new File("C:\\Users\\hejin\\Desktop\\其他\\jay.jpg");  //文件的位置
        //        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
    }

    @Test
    public void testUploadAndCreateThumb() throws FileNotFoundException{
        File file = new File("C:\\Users\\hejin\\Desktop\\其他\\头像.jpg");  // 文件的上传路径
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file), file.length(), "jpg", null);
        // 带分组的路径
        System.out.println(storePath.getFullPath());
        // 不带分组的路径
        System.out.println(storePath.getPath());
        // 获取缩略图路径
        String thumbImagePath = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(thumbImagePath);
    }

    public StringBuffer upLoad(String filePath) throws FileNotFoundException {
        StringBuffer fDfsPath = new StringBuffer("http://39.108.98.95:8080/");
        File file = new File(filePath);
        StorePath storePath = this.storageClient.uploadFile(
                new FileInputStream(file), file.length(), "jpg", null);
        System.out.println("带分组的路径："+storePath.getFullPath());
        fDfsPath.append(storePath.getFullPath());
        System.out.println("追加之后的路径为："+fDfsPath);
        return fDfsPath;
    }

    @Test
    public void test() throws FileNotFoundException{
        String filePath = "C:\\Users\\hejin\\Desktop\\dd6719bd4287d9efd49434c43563a032_v2_.jpg";
        upLoad(filePath);
    }
}
