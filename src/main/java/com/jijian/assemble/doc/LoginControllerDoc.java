package com.jijian.assemble.doc;

import com.jijian.business.entity.businessEntity;
import com.jijian.common.ResultJson;
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
    ResultJson<Boolean> getVerifyCode(@ApiParam(value = "phone", required = true) String phone,HttpServletRequest request);

    @ApiOperation("登陆功能")
    ResultJson<businessEntity> login(@ApiParam(value = "phone", required = true) String phone, @ApiParam(value = "code", required = false) String code, @ApiParam(value = "password", required = false) String password,
                                     @ApiParam(value = "loginType") Integer loginType, HttpServletRequest request);

    @ApiOperation("注册功能")
    ResultJson<UserInfoDTO> register(@ApiParam(value = "phone", required = true) String phone, @ApiParam(value = "code", required = true) String code,
                                     @ApiParam(value = "password", required = true) String password, @ApiParam(value = "type", required = true) String type,@ApiParam(value = "area", required = true) String area,HttpServletRequest request);
}
