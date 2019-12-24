package com.jijian.file.doc;

import com.jijian.common.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Author: chenchuan
 * Date: 2019/12/11 14:15
 * Content:
 */
@Api(tags = "上传图片，修改图片功能")
public interface FileControllerDoc {
    /**
     * 上传图片
     * */
    @ApiOperation("上传图片")
    public ResultJson fileUpload(MultipartFile file , String fileType , HttpServletRequest request);
    /***
     * 修改图片信息
     * **/
    @ApiOperation("修改图片")
    public ResultJson fileUpload(@RequestBody Map<String ,Object> fileinfo ,HttpServletRequest request);
}
