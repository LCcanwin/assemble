package com.jijian.assemble.controller;


import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.entity.User;
import com.jijian.assemble.service.GoodsService;
import com.jijian.common.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods/api")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取所有商品信息
     * @return
     */
    @RequestMapping(value = "/goodsList" ,method = RequestMethod.GET)
    public List<Goods> getGoodslist() {
        List<Goods> listU = goodsService.findAllList();
        return listU;
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public Goods getGoods(@PathVariable("id") String id) {
        Goods goods = goodsService.getById(id);
        return goods;
    }

    /**
     * 获取商家自己的商品
     * @param businessId
     * @return
     */
    @RequestMapping(value = "/findByBusiness/{businessId}" ,method = RequestMethod.GET)
    public  List<Goods> findByBusiness(@PathVariable("businessId") String businessId) {
        List<Goods> goods = goodsService.findByBusiness(businessId);
        return goods;
    }

    /**
     * 新增商品
     * @param goods
     * @return
     */
    @RequestMapping(value = "/addGoods" ,method = RequestMethod.POST)
    public ResultJson<GoodsDTO> addGoods(@RequestBody Goods goods) {
        Integer i = goodsService.addGoods(goods);
        if(i>0){
            return ResultJson.getReturnJson("新增成功！", null);
        }else{
            return ResultJson.getReturnJson("新增失败！", null);
        }
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.DELETE)
    public ResultJson<GoodsDTO> delete(@PathVariable("id")String id) {
        Integer i = goodsService.delete(id);
        if(i>0){
            return ResultJson.getReturnJson("删除成功！", null);
        }else{
            return ResultJson.getReturnJson("删除失败！", null);
        }
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @RequestMapping(value = "/updateGoods/{id}" ,method = RequestMethod.PUT)
    public ResultJson<GoodsDTO> updateGoods(@RequestBody Goods goods) {
        Integer i = goodsService.update(goods);
        if(i>0){
            return ResultJson.getReturnJson("修改成功！", null);
        }else{
            return ResultJson.getReturnJson("修改失败！", null);
        }
    }
}
