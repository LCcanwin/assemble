package com.jijian.assemble.service.impl;

import com.jijian.assemble.service.LoginService;
import com.jijian.utils.HttpClientUtil;
import com.jijian.utils.SendMessage;
import org.springframework.stereotype.Service;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/21 22:37
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public Integer getVerifyCode(String phone,Integer code) {
        HttpClientUtil client = HttpClientUtil.getInstance();
        //短信内容
        String smsText = "验证码："+ code;
        //UTF发送
        return client.sendMsgUtf8(SendMessage.Uid, SendMessage.Key,smsText ,phone);
    }
}
