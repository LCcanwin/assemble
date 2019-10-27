package com.jijian.assemble.service.impl;

import com.jijian.assemble.dto.UserInfoDTO;
import com.jijian.assemble.mapper.UserMapper;
import com.jijian.assemble.service.LoginService;
import com.jijian.assemble.utils.HttpClientUtil;
import com.jijian.assemble.utils.MD5Util;
import com.jijian.assemble.utils.SendMessage;
import com.jijian.assemble.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/21 22:37
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Integer getVerifyCode(String phone, Integer code) {
        HttpClientUtil client = HttpClientUtil.getInstance();
        //短信内容
        String smsText = "验证码：" + code;
        //UTF发送
        return client.sendMsgUtf8(SendMessage.Uid, SendMessage.Key, smsText, phone);
    }

    /**
     * 注册功能
     *
     * @param phone
     * @param password
     * @return
     */
    @Override
    public UserInfoDTO register(String phone, String password) {
        String md5Password = MD5Util.getMD5(password);
        int count = userMapper.register(phone, md5Password);
        //生成token
        String token = TokenUtil.makeToken();
        userMapper.makeToken(token, phone);
        UserInfoDTO userInfoDTO = userMapper.getUserInfo(phone);
        return userInfoDTO;
    }

    @Override
    public UserInfoDTO loginByCode(String phone) {
        return userMapper.getUserInfo(phone);
    }

    @Override
    public UserInfoDTO loginByPassword(String phone, String password) {
        String md5Password = MD5Util.getMD5(password);
        String resultPassword = userMapper.getPassword(phone);
        if (resultPassword.equals(md5Password)) {
            return userMapper.getUserInfo(phone);
        } else {
            return null;
        }
    }

    @Override
    public Boolean isRegister(String phone) {
        Integer count = userMapper.userCount(phone);
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }
}
