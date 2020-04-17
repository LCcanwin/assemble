package com.jijian.shoptype.controller;

import com.jijian.common.ResultJson;
import com.jijian.shoptype.service.shopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: chenchuan
 * Date: 2019/12/19 14:35
 * Content:
 */

@RestController
public class shopTypeController {
    @Autowired private shopTypeService shoptypeservice;

    @RequestMapping("/getShopType")
    public ResultJson getShopType(){
        return ResultJson.getReturnJson(200,"返回成功!",shoptypeservice.searchShopType());
    }

    @RequestMapping("/getAreaList")
    public ResultJson getAreaList(){
        return ResultJson.getReturnJson(200,"返回成功!",shoptypeservice.getAreaList());
    }
}
