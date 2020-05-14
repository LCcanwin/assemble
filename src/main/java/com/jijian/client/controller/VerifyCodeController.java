package com.jijian.client.controller;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.assemble.service.GoodsService;
import com.jijian.assemble.service.LoginService;
import com.jijian.common.Constant;
import com.jijian.common.ResultJson;
import com.jijian.utils.RedisUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Api(description = "发送短信接口")
@Controller("verify")
@RequestMapping("/client/api/verify")
public class VerifyCodeController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "获取短信验证码", notes="获取短信验证码")
    @ApiImplicitParam(name = "phone", value = "电话号码", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/getVerifyCode", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Integer> getVerifyCode(@RequestParam(value = "phone", required = true) String phone, HttpServletRequest request) {

        int verifyCode = (int) ((Math.random() * 9 + 1) * 100000);
        HttpSession session = request.getSession();
        session.setAttribute(Constant.VERIFY_CODE, verifyCode);

        redisUtils.set(String.valueOf(verifyCode), verifyCode);
        redisUtils.set(phone, phone);

        int result = loginService.getVerifyCode(phone, verifyCode);
        if (result > 0) {
            return ResultJson.getReturnJson(200,"验证码发送成功！", verifyCode);
        } else {
            return ResultJson.getReturnJson(500,"验证码发送失败！", verifyCode);
        }
    }

    @ApiOperation(value = "验证手机号", notes="验证手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "验证码", paramType = "query", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "电话号码", paramType = "query", required = true, dataType = "String")
    })
    @RequestMapping(value = "/validatePhoneCode", method = RequestMethod.GET)
    @ResponseBody
    public ResultJson<Boolean> validatePhoneCode( String code,String phone, HttpServletRequest request){
        String redisCode= String.valueOf(redisUtils.get(code));
        String phoneCode= String.valueOf(redisUtils.get(phone));

        if(redisCode!=null&&phoneCode!=null){
            if (phone.equals(phoneCode)&&code.equals(redisCode)) {
                return ResultJson.getReturnJson(200,"验证成功！", true);
            } else {
                return ResultJson.getReturnJson(500,"验证失败！手机、验证码不匹配", null);
            }
        }else{
            return ResultJson.getReturnJson(500,"验证失败！手机号或者验证码不正确", null);
        }
    }
}
