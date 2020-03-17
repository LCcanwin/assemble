package com.jijian.file.service;

//import com.jijian.base.BaseService;
//import com.jijian.common.ResultJson;
import com.jijian.file.entity.FileEntity;

import java.io.File;
import java.util.Map;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:25
 * Content:
 */
public interface FileService  {
    /*
     * @Param FileEntity
     * @date 2019/10/21 11:26
     * @author chenchuan
     * Content：添加文件
     * */
    int insert(FileEntity fileEntity);
    /*
     * @Param FileEntity
     * @date 2019/12/10 11:26
     * @author chenchuan
     * Content：修改文件
     * */
    int updatefile (Map<String ,Object> fileinfo);
}
