package com.jijian.client.controller;


import com.jijian.client.Dto.TypeDto;
import com.jijian.client.Dto.VersionDTO;
import com.jijian.client.service.TypeService;
import com.jijian.client.service.VersionService;
import com.jijian.common.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "版本信息相关接口")
@Controller("version")
@RequestMapping("/client/api/version")
public class VersionController {


    @Autowired
    private VersionService versionService;


    @ApiOperation(value = "检查版本信息", notes = "检查版本信息")
    @RequestMapping(value = "/checkVersion", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Object> checkVersion(Integer number) {
        VersionDTO versionDTO=versionService.getLastVersion(number);
        if(versionDTO==null){
            return ResultJson.getReturnJson(200, "该版本已是最新版本！", null);
        }
        return ResultJson.getReturnJson(200, "查询到最新版本，请更新！", versionDTO);
    }
}
