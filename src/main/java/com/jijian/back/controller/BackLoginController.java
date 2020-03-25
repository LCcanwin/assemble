package com.jijian.back.controller;


import com.jijian.back.entity.SysUser;
import com.jijian.back.service.StatService;
import com.jijian.back.service.SysUserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BackLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private StatService statService;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/back/api/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, String name, String password, Model model){
        SysUser sysUser=sysUserService.login(name,password);

        if(sysUser!=null ){
            request.getSession().setAttribute("currentUser",sysUser);
            Integer businessCount=statService.businessCount("");
            Integer businessCount0=statService.businessCount("0");
            Integer businessCount1=statService.businessCount("1");
            model.addAttribute("count",businessCount);
            model.addAttribute("count0",businessCount0);
            model.addAttribute("count1",businessCount1);
            return "index";
        }else{
            model.addAttribute("logMsg","账号密码错误，请重新输入!");
            return "login";
        }

    }

    @RequestMapping(value = "/back/api/loginOut",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("currentUser");
        return "login";
    }

    @RequestMapping(value = "/back/api/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model){
        Integer businessCount=statService.businessCount("");
        Integer businessCount0=statService.businessCount("0");
        Integer businessCount1=statService.businessCount("1");
        model.addAttribute("count",businessCount);
        model.addAttribute("count0",businessCount0);
        model.addAttribute("count1",businessCount1);
        return "index";
    }

}
