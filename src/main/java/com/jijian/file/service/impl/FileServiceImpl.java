package com.jijian.file.service.impl;

//import com.jijian.base.BaseService;
//import com.jijian.base.BaseServiceImpl;
import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;
import com.jijian.file.mapper.FileMapper;
import com.jijian.file.service.FileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:28
 * Content:
 */
@Service
public class FileServiceImpl  implements FileService {
    @Resource
    private FileMapper fileMapper;
    @Override
    public int insert(FileEntity fileEntity) {
        return fileMapper.insert(fileEntity);
    }

    @Override
    public int updatefile(Map<String ,Object> fileinfo) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setUId(fileinfo.get("uId").toString());
        fileEntity.setBId(fileinfo.get("bId").toString());
        fileEntity.setUpdateUser(fileinfo.get("uId").toString());
       // String id = fileinfo.get("id").toString();
        String ids [] = fileinfo.get("id").toString().split(",");
        for (int i = 0 ; i< ids .length;i++){
            fileEntity.setId(Integer.parseInt(ids[i]));
            fileMapper.updatefile(fileEntity);
        }
        return 1;
    }

}
