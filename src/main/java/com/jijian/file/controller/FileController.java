package com.jijian.file.controller;

import com.jijian.base.BaseController;
import com.jijian.base.BaseService;
import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.service.FileService;
import com.jijian.utils.DateTimeUtil;
import com.jijian.utils.DirectoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:31
 * Content:
 */
@RestController
public class FileController {
    @Autowired private FileService fileService;
    @RequestMapping("/multiUpload")
    @ResponseBody
    public Map<String, Object> multiUpload(HttpServletRequest request) {
        Map<String, Object> helper = new HashMap<String, Object>();
        try {
            StandardServletMultipartResolver standardServletMultipartResolver = new StandardServletMultipartResolver();
            if (standardServletMultipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = standardServletMultipartResolver.resolveMultipart(request);
                Iterator<String> iter = multiRequest.getFileNames();
                // 批量上传
                String uploadDirectory = DirectoryUtil.getRootPathWithDate();
                File uploadFile = new File(uploadDirectory);
                if (!uploadFile.exists()) {
                    uploadFile.mkdirs();
                }
                List<FileEntity> fileEntityList = new ArrayList<FileEntity>();
                while (iter.hasNext()) {
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if (file != null) {
                        String fileName = file.getOriginalFilename();
                        String fileNamePath = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString().replace("-", "").toLowerCase();
                        // 下面的加的日期是为了防止上传的名字一样
                        if (!uploadDirectory.endsWith("/")) {
                            uploadDirectory += "/";
                        }
                        FileEntity fileEntity = new FileEntity();
                        String path = uploadDirectory + fileNamePath + fileName;
                        File localFile = new File("E:/testImg");
                        file.transferTo(localFile);
                        fileEntity.setFileName(fileName);
                        fileEntity.setFileNewName(fileNamePath);
                        fileEntity.setFileUrl(path);
                        fileEntity.setFileType("2");
                        fileEntityList.add(fileEntity);
                        fileService.insert(fileEntity);
                    }
                }
            }
            helper.put("code", "01");
        } catch (Exception e) {
            e.printStackTrace();
            helper.put("code", "02");
        }
        return helper;
    }


    //批量文件上传
    @PostMapping("/dc/moreFileUpload")
    public String bacthFileUpload(MultipartFile[] file,@RequestBody Map<String,String> params) throws IOException {
        StringBuffer buffer = new StringBuffer();
        for (MultipartFile multipartFile : file) {

            String str ="";// fileUpload(multipartFile,params);
            buffer.append(str);
            buffer.append(",");
        }
        String all = buffer.substring(0, buffer.length() - 1);
        return all;
    }

    //单个文件上传
    @RequestMapping("/fileUpload")
    @ResponseBody
    public ResultJson fileUpload(MultipartFile file , String fileType){
        // 获取上传文件名
        String uploadPathName = file.getOriginalFilename();
        // 获取上传文件的后缀
        String fileSuffix = uploadPathName.substring(uploadPathName.lastIndexOf(".") + 1, uploadPathName.length());
            // 上传目录地址
         String uploadpath="E:/manage/image";//windows路径
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
            fileEntity.setFileUrl(uploadpath+"/"+fileNewName);
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
    public ResultJson fileUpload(@RequestBody Map<String ,Object>  fileinfo){
        if(fileService.updatefile(fileinfo)>0){
            return ResultJson.getReturnJson(200,"修改成功!",null);
        }
        return ResultJson.getReturnJson("修改失败!");
    }
}
