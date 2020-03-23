package com.jijian.file.controller;

import com.jijian.common.Constant;
import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:31
 * Content:
 */
@RestController
public class FileController {
    @Autowired private FileService fileService;


    //单个文件上传
    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResultJson fileUpload(MultipartFile file , String fileType , String bId, HttpServletRequest request){



        // 获取上传文件名
        String uploadPathName = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPathName.substring(uploadPathName.lastIndexOf(".") + 1, uploadPathName.length());
            // 上传目录地址
//         String uploadpath="D:/manage/image/";//windows路径
         String uploadpath= Constant.IMAGE_PATH;//windows路径
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
//            fileEntity.setFileUrl("/image/url/"+fileNewName);
            fileEntity.setFileUrl(uploadpath+fileNewName);
            if(fileService.insert(fileEntity)>0){
                return ResultJson.getReturnJson(200,"上传成功!",fileEntity);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultJson.getReturnJson("上传失败!");
    }
    //文件修改
    @RequestMapping("/fileUpdate")
    @ResponseBody
    public ResultJson fileUpload(@RequestBody Map<String ,Object>  fileinfo,HttpServletRequest request){
        if(fileService.updatefile(fileinfo)>0){
            return ResultJson.getReturnJson(200,"修改成功!",null);
        }
        return ResultJson.getReturnJson("修改失败!");
    }
}
