package com.jijian.assemble.controller;

import com.jijian.assemble.common.ResultJson;
import com.jijian.assemble.doc.LoginControllerDoc;
import com.jijian.assemble.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 登陆注册相关
 * @Author luochao
 * @Date 2019/10/20
 */
@RestController
@RequestMapping("/business/api")
public class LoginController implements LoginControllerDoc {

    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET)
    public ResultJson<String> getVerifyCode(@RequestParam(value = "phone", required = true) String phone) {
        return ResultJson.getReturnJson("", null);

    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultJson<UserInfoDTO> login(@RequestParam(value = "phone", required = true) String phone, @RequestParam(value = "code", required = false) String code, @RequestParam(value = "password", required = false) String password,
                                         @RequestParam(value = "loginType") Integer loginType, HttpServletRequest request) {
        return ResultJson.getReturnJson("", null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResultJson<UserInfoDTO> register(@RequestParam(value = "phone", required = true) String phone, @RequestParam(value = "code", required = false) String code,
                                        @RequestParam(value = "password", required = false) String password, HttpServletRequest request) {
        return ResultJson.getReturnJson("", null);
    }

}
