package com.jijian.file.controller;

import com.jijian.file.entity.FileEntity;
import com.jijian.file.service.FileService;
import com.jijian.utils.DirectoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:31
 * Content:
 */
@RestController
public class FileController {
    @Autowired
    FileService fileService;
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
                        fileService.insertFile(fileEntity);
                        String path = uploadDirectory + fileNamePath + fileName;
                       /* File localFile = new File(path);
                        file.transferTo(localFile);*/


                        fileEntity.setFileNewName(fileName);
                        fileEntity.setFileUrl(path);
                        fileEntityList.add(fileEntity);
                        fileService.insertFile(fileEntity);
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


}
