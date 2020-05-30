package com.jijian.client.controller;


import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.PinkDTO;
import com.jijian.client.entity.Order;
import com.jijian.client.service.OrderService;
import com.jijian.client.service.PinkService;
import com.jijian.common.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(description = "拼单相关接口")
@Controller("pink")
@RequestMapping("/client/api/pink")
public class PinkController {



    @Autowired
    private PinkService pinkService;

//    @ApiOperation(value = "获取用户拼单列表", notes = "获取用户拼单列表")
//    @ApiImplicitParam(name = "customerId", value = "用户id", paramType = "query", required = true, dataType = "String")
//    @RequestMapping(value = "/findPinkByCustomer", method = RequestMethod.GET)
//    @ResponseBody
//    public ResultJson<List<PinkDTO>> findPinkByCustomer(String customerId) {
//        List<PinkDTO> pinkDTOList=pinkService.findPinkByCustomer(customerId);
//        return ResultJson.getReturnJson(200, "查询成功！", pinkDTOList);
//    }

    @ApiOperation(value = "获取商品拼单列表", notes = "获取商品拼单列表")
    @ApiImplicitParam(name = "goodsId", value = "商品id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/findPinkByGoodsId", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<List<PinkDTO>> getListByCustomerId(String goodsId) {
        List<PinkDTO> pinkDTOList=pinkService.findPinkByGoodsId(goodsId);
        return ResultJson.getReturnJson(200, "查询成功！", pinkDTOList);
    }



    @ApiOperation(value = "获取拼单详情", notes = "获取拼单详情")
    @ApiImplicitParam(name = "id", value = "拼单id", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<PinkDTO> get(String id) {
        PinkDTO pinkDTO = pinkService.get(id);
        return ResultJson.getReturnJson(200, "查询成功！", pinkDTO);
    }



}
