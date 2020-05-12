package com.jijian.client.controller;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.service.GoodsService;
import com.jijian.common.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Api(description = "商品相关接口")
@Controller("goods")
@RequestMapping("/client/api/goods")
public class GoodsClController {

    @Autowired
    private GoodsService goodsService;



    /**
     * 获取商品信息
     * @return
     */
    @ApiOperation(value = "获取限时促销，今日推荐，发现好物商品信息", notes="获取限时促销，今日推荐，发现好物商品信息")
    @ApiImplicitParam(name = "salesFlag", value = "销售状态", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    @ResponseBody
    public ResultJson< List<GoodsDTO>> getGoodsList(String salesFlag) {
        List<GoodsDTO> listU = goodsService.findGoodsBySalesFlag(salesFlag);
        return new ResultJson(200,"查询成功！",listU);
    }
}
