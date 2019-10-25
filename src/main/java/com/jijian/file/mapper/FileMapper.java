package com.jijian.file.mapper;

import com.jijian.file.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:18
 * Content:
 */
@Mapper
public interface FileMapper {
    int insertFile(FileEntity fileEntity);
}
