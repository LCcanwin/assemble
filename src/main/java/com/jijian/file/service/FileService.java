package com.jijian.file.service;

import com.jijian.file.entity.FileEntity;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:25
 * Content:
 */
public interface FileService {
    /**
     * @Param FileEntity
     * @date 2019/10/21 11:26
     * @author chenchuan
     * Content：添加文件
     * **/
    int insertFile(FileEntity fileEntity);
}
