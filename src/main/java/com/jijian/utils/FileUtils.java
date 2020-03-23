package com.jijian.utils;

import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class FileUtils {

    public static FileEntity fileUpload(MultipartFile file , String fileType , String bId){
        // 获取上传文件名
        String uploadPathName = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPathName.substring(uploadPathName.lastIndexOf(".") + 1, uploadPathName.length());
        // 上传目录地址
         String uploadpath="E:/manage/image";//windows路径
//        String uploadpath="/data/image";
        // 上传文件名
        String fileNewName = new Date().getTime() + new Random().nextInt(100) + "." + fileSuffix;
        File savefile = new File(uploadpath+fileNewName);
        if (!savefile.getParentFile().exists()) {
            savefile.getParentFile().mkdirs();
        }
        FileEntity fileEntity = new FileEntity();

        try {
            file.transferTo(savefile);
            fileEntity.setFileName(uploadPathName);
            fileEntity.setFileNewName(fileNewName);
            fileEntity.setDeleted(0);
            fileEntity.setFileType(fileType);
            fileEntity.setBId(bId);
            fileEntity.setFileUrl("/image/url/"+fileNewName);
            return fileEntity;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
