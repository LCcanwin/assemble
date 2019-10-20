package com.jijian.assemble.doc;

import com.jijian.assemble.common.ResultJson;
import com.jijian.assemble.dto.UserInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 登陆注册swagger
 * @Author luochao
 * @Date 2019/10/20 15:49
 */
@Api(tags = "登陆、注册功能")
public interface LoginControllerDoc {
    @ApiOperation("获取验证码")
    ResultJson<String> getVerifyCode(@ApiParam(value = "phone", required = true) String phone);

    @ApiOperation("登陆功能")
    ResultJson<UserInfoDTO> login(@ApiParam(value = "phone", required = true) String phone, @ApiParam(value = "code", required = false) String code, @ApiParam(value = "password", required = false) String password,
                              @ApiParam(value = "loginType") Integer loginType, HttpServletRequest request);

    @ApiOperation("注册功能")
    ResultJson<UserInfoDTO> register(@ApiParam(value = "phone", required = true) String phone, @ApiParam(value = "code", required = true) String code,
                                     @ApiParam(value = "password", required = true) String password, HttpServletRequest request);
}
