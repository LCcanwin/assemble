package com.jijian.back.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.service.GoodsService;
import com.jijian.business.entity.businessEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 后台商品管理Controller
 */
@Controller
@RequestMapping("/back/api/goods")
public class BackGoodsController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/list")
    public String getList(Goods goods,@RequestParam(required = false,defaultValue="1",value="pageNum") int pageNum, @RequestParam(defaultValue="10",value="pageSize")int size, Model model){
        PageHelper.startPage(pageNum,size);
        List<Goods> list=goodsService.findList(goods);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(list,size);
        model.addAttribute("pageInfo",pageInfo);
        return "goodsList";
    }

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/detail" ,method = RequestMethod.GET)
    public String getGoods(@RequestParam("id") String id,Model model) {
        Goods goods = goodsService.getById(id);
        model.addAttribute("detail",goods);
        return "goodsDetail";
    }
}
