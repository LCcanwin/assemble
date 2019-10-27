package com.jijian.assemble.controller;

import com.jijian.assemble.common.Constant;
import com.jijian.assemble.common.ResultJson;
import com.jijian.assemble.doc.LoginControllerDoc;
import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description 登陆注册相关
 * @Author luochao
 * @Date 2019/10/20
 */
@RestController
@RequestMapping("/business/api")
public class LoginController implements LoginControllerDoc {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET)
    public ResultJson<Boolean> getVerifyCode(@RequestParam(value = "phone", required = true) String phone, HttpServletRequest request) {
        int verifyCode = (int) ((Math.random() * 9 + 1) * 100000);
        HttpSession session = request.getSession();
        session.setAttribute(Constant.VERIFY_CODE, verifyCode);
        int result = loginService.getVerifyCode(phone, verifyCode);
        if (result > 0) {
            return ResultJson.getReturnJson("验证码发送成功！", true);
        } else {
            return ResultJson.getReturnJson("验证码发送失败！", false);
        }

    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultJson<UserInfoDTO> login(@RequestParam(value = "phone", required = true) String phone, @RequestParam(value = "code", required = false) String code, @RequestParam(value = "password", required = false) String password,
                                         @RequestParam(value = "loginType") Integer loginType, HttpServletRequest request) {
        if (loginType == 1) {
            UserInfoDTO userInfo = loginService.loginByPassword(phone, password);
            if (userInfo == null) {
                return ResultJson.getReturnJson("密码错误！", null);
            } else {
                return ResultJson.getReturnJson(userInfo);
            }
        } else {
            HttpSession session = request.getSession();
            Object sessionCode = session.getAttribute(Constant.VERIFY_CODE);
            if (code.equals(String.valueOf(sessionCode))) {
                return ResultJson.getReturnJson(loginService.loginByCode(phone));
            } else {
                return ResultJson.getReturnJson("登陆失败！验证码不正确", null);
            }
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ResultJson<UserInfoDTO> register(@RequestParam(value = "phone", required = true) String phone, @RequestParam(value = "code", required = false) String code,
                                            @RequestParam(value = "password", required = false) String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object sessionCode = session.getAttribute(Constant.VERIFY_CODE);
        if (code.equals(String.valueOf(sessionCode))) {
            if (loginService.isRegister(phone)) {
                return ResultJson.getReturnJson(loginService.register(phone, password));
            } else {
                return ResultJson.getReturnJson("你已经注册过啦！", null);
            }
        } else {
            return ResultJson.getReturnJson("注册失败！验证码不正确", null);
        }
    }

}
