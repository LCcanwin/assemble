package com.jijian.assemble.service;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/21 22:34
 */
public interface LoginService {
    Integer getVerifyCode(String phone,Integer code);
}
