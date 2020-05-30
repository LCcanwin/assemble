package com.jijian.back.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jijian.client.Dto.VersionDTO;
import com.jijian.client.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/back/api/version")
public class BackVersionController {


    @Autowired
    private VersionService versionService;

    @RequestMapping("/versionList")
    public String businessList(@RequestParam(required = false,defaultValue="1",value="pageNum") int pageNum, @RequestParam(defaultValue="10",value="pageSize")int size, Model model){

        PageHelper.startPage(pageNum,size);
        List<VersionDTO> list=versionService.findList();
        PageInfo<VersionDTO> pageInfo = new PageInfo<VersionDTO>(list,size);
        model.addAttribute("pageInfo",pageInfo);
        return "versionList";
    }
}
