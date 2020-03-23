package com.jijian.back.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jijian.business.entity.businessEntity;
import com.jijian.business.service.businessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/back/api/business")
public class BackBusinessController {


    @Autowired
    private businessService businessService;

    @RequestMapping("/businessList")
    public String businessList(businessEntity businessEntity, @RequestParam(required = false,defaultValue="1",value="pageNum") int pageNum, @RequestParam(defaultValue="10",value="pageSize")int size, Model model){

        PageHelper.startPage(pageNum,size);
        List<businessEntity> list=businessService.findList(businessEntity);
        PageInfo<businessEntity> pageInfo = new PageInfo<businessEntity>(list,size);
        model.addAttribute("pageInfo",pageInfo);
        return "businessList";
    }


    @RequestMapping("/businessDetail")
    public String businessDetail(@RequestParam(required = true,value="id")String id,Model model){
         businessEntity businessEntity= businessService.get(id);
        model.addAttribute("detail",businessEntity);
        return "businessDetail";
    }

    @RequestMapping("/businessDeal")
    public String businessDeal(@RequestParam(required = true,value="id")String id,Model model){
        if(businessService.businessDeal(id)>0){
            businessEntity businessEntity= businessService.get(id);
            model.addAttribute("detail",businessEntity);
        }
        return "businessDetail";
    }
}
