package com.jijian.client.controller;


import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.service.CustomerService;
import com.jijian.client.service.TypeService;
import com.jijian.common.Constant;
import com.jijian.common.ResultJson;
import com.jijian.utils.RedisUtils;
import com.jijian.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Api(description = "分类相关接口")
@Controller("type")
@RequestMapping("/client/api/type")
public class TypeController {


    @Autowired
    private TypeService typeService;


    @ApiOperation(value = "获取分类列表", notes = "获取分类列表")
    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<TypeDto>> findList(String id) {
        List<TypeDto> typeDtoList=typeService.findList();
        return ResultJson.getReturnJson(200, "查询成功！", typeDtoList);
    }

    @ApiOperation(value = "获取分类列表(单独)", notes = "获取分类列表(单独)")
    @ApiImplicitParam(name = "parentId", value = "分类父Id", paramType = "query", required = false, dataType = "String")
    @RequestMapping(value = "/findListByPid", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<TypeDto>> findListByPid(String parentId) {
        List<TypeDto> typeDtoList=typeService.findListByPid(parentId);
        return ResultJson.getReturnJson(200, "查询成功！", typeDtoList);
    }
}
