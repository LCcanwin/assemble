package com.jijian.file.service.impl;

import com.jijian.file.entity.FileEntity;
import com.jijian.file.mapper.FileMapper;
import com.jijian.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:28
 * Content:
 */
@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileMapper fileMapper;
    @Override
    public int insertFile(FileEntity fileEntity) {
        return fileMapper.insertFile(fileEntity);
    }
}
