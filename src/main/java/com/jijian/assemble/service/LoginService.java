package com.jijian.assemble.service;

import com.jijian.assemble.dto.UserInfoDTO;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/21 22:34
 */
public interface LoginService {
    Integer getVerifyCode(String phone,Integer code);
    UserInfoDTO register(String phone, String password,String type,String area);
    UserInfoDTO loginByCode(String phone);
    UserInfoDTO loginByPassword(String phone, String password);
    Boolean isRegister(String phone);

    Integer updatePassword(String phone,String password);
}
