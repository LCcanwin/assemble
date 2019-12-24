package com.jijian.goodstype.controller;

import com.jijian.common.ResultJson;
import com.jijian.goodstype.POJO.goodsTypePOJO;
import com.jijian.goodstype.entity.goodsTypeEntity;
import com.jijian.goodstype.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 14:10
 * Content:
 */
@RestController
public class goodsTypeController {
    @Autowired  private goodsTypeService goodstypeservice;
    @RequestMapping("/getgoodstype")
    @ResponseBody
    public ResultJson getGoodsType(){
        List<goodsTypePOJO> listGoodsType = new ArrayList<>();
        try{
            listGoodsType= goodstypeservice.searchGoodsType();
            return ResultJson.getReturnJson(200,"返回成功!",listGoodsType);
        }catch (Exception e){
            e.printStackTrace();
            return ResultJson.getReturnJson(400,"返回失败!",null);
        }
    }
}
